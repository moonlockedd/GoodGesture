package repositories;

import data.interfaces.IDataBase;
import lombok.AllArgsConstructor;
import models.Program;
import models.University;
import repositories.interfaces.IProgramRepository;
import repositories.interfaces.IUniversityRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class UniversityRepository implements IUniversityRepository {
    private final IDataBase db;
    private final IProgramRepository programRepo;

    @Override
    public List<University> getAll() {
        Connection con = null;
        List<University> universities = new ArrayList<>();

        try {
            con = db.getConnection();

            // Query to get all universities
            String query = "SELECT id,name,program_ids FROM universities";
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            // Iterate through result set, create University instance and add it to the list
            while (rs.next()) {
                // Convert SQL array into integer array
                Array sqlArr = rs.getArray("program_ids");
                Integer[] idArr = (Integer[]) sqlArr.getArray();

                // List to store all programs in the university
                List<Program> programs = programRepo.getAllByIds(idArr);

                universities.add(new University(
                        rs.getInt("id"),
                        rs.getString("name"),
                        programs
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        return universities;
    }

    @Override
    public University getById(int id) {
        Connection con = null;

        try {
            con = db.getConnection();

            // Query to get university by id
            String query = "SELECT id,name,program_ids FROM universities " +
                    "WHERE id=?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            // If university in the table, return it
            if (rs.next()) {
                // Convert SQL array into integer array
                Array sqlArr = rs.getArray("program_ids");
                Integer[] idArr = (Integer[]) sqlArr.getArray();

                // List to store all programs in the university
                List<Program> programs = programRepo.getAllByIds(idArr);

                return new University(
                        rs.getInt("id"),
                        rs.getString("name"),
                        programs
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        return null;
    }

    @Override
    public boolean create(University university) {
        Connection con = null;

        try {
            con = db.getConnection();

            // Query to insert new university into the table
            String query = "INSERT INTO universities (name,program_ids) " +
                    "VALUES(?,?)";
            PreparedStatement stmt = con.prepareStatement(query);

            // List to store all programs
            List<Program> programs = new ArrayList<>();

            // Iterate through program in university
            for (Program program : university.getPrograms()) {
                // insert program into database
                boolean created = programRepo.create(program);

                // If insertion is successful, add that program to the list
                if (created) {
                    programs.add(programRepo.getLastCreated());
                }
            }

            // Integer array to store program ids
            Integer[] idArr = new Integer[programs.size()];

            // Iterate through program list and add id of each program to the array
            for (int i = 0; i < programs.size(); i++) {
                idArr[i] = programs.get(i).getId();
            }

            Array sqlArr = con.createArrayOf("integer", idArr);

            // Set fields
            stmt.setString(1, university.getName());
            stmt.setArray(2, sqlArr);

            stmt.execute();

            // Return true if insertion is successful
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        return false;
    }

    @Override
    public University getLastCreated() {
        Connection con = null;

        try {
            con = db.getConnection();

            // Query to get last created university
            String query = "SELECT id,name,program_ids FROM universities " +
                    "ORDER BY id DESC LIMIT 1";
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            // If table is not empty, return university
            if (rs.next()) {
                // Convert SQL array to integer array
                Array sqlArr = rs.getArray("program_ids");
                Integer[] idArr = (Integer[]) sqlArr.getArray();

                List<Program> programs = programRepo.getAllByIds(idArr);

                return new University(
                        rs.getInt("id"),
                        rs.getString("name"),
                        programs
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        return null;
    }
}
