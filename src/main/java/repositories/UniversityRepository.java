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

            String query = "SELECT id,name,program_ids FROM universities";
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Array sqlArr = rs.getArray("program_ids");
                Integer[] idArr = (Integer[]) sqlArr.getArray();

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

            String query = "SELECT id,name,program_ids FROM universities " +
                    "WHERE id=?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
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

    @Override
    public boolean create(University university) {
        Connection con = null;

        try {
            con = db.getConnection();

            String query = "INSERT INTO universities (name,program_ids) " +
                    "VALUES(?,?)";
            PreparedStatement stmt = con.prepareStatement(query);

            List<Program> programs = new ArrayList<>();

            for (Program program : university.getPrograms()) {
                boolean created = programRepo.create(program);

                if (created) {
                    programs.add(programRepo.getLastCreated());
                }
            }

            Integer[] idArr = new Integer[programs.size()];

            for (int i = 0; i < programs.size(); i++) {
                idArr[i] = programs.get(i).getId();
            }

            Array sqlArr = con.createArrayOf("integer", idArr);

            stmt.setString(1, university.getName());
            stmt.setArray(2, sqlArr);

            stmt.execute();

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

            String query = "SELECT id,name,program_ids FROM universities " +
                    "ORDER BY id DESC LIMIT 1";
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
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
