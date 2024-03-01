package repositories;

import data.interfaces.IDataBase;
import lombok.AllArgsConstructor;
import models.Program;
import repositories.interfaces.IProgramRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class ProgramRepository implements IProgramRepository {
    private final IDataBase db;

    @Override
    public List<Program> getAll() {
        Connection con = null;
        // List to store programs
        List<Program> programs = new ArrayList<>();

        try {
            con = db.getConnection();

            // Query to get all programs
            String query = "SELECT id, name, electives, minimum_score FROM programs";
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            // Iterate through result set, create new program instance and append to the list
            while (rs.next()) {
                // Convert SQL array into string array
                Array sqlArr = rs.getArray("electives");
                String[] electivesArr = (String[]) sqlArr.getArray();

                programs.add(new Program(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("minimum_score"),
                        electivesArr
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

        return programs;
    }
    @Override
    public Program getById(int id) {
        Connection con = null;

        try {
            con = db.getConnection();

            // Query to get program by id
            String query = "SELECT id, name, electives, minimum_score FROM programs WHERE id=?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            // If program is in table return it
            if (rs.next()) {
                // Convert SQL array into string array
                Array sqlArr = rs.getArray("electives");
                String[] electivesArr = (String[]) sqlArr.getArray();

                return new Program(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("minimum_score"),
                        electivesArr
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
    public List<Program> getAllByIds(Integer[] ids) {
        Connection con = null;
        // List to store programs
        List<Program> programs = new ArrayList<>();

        try {
            con = db.getConnection();

            // Iterate through every id in ids
            for (Integer id : ids) {
                // Query to get program with that id
                String query = "SELECT id,name,electives,minimum_score " +
                        "FROM programs WHERE id=?";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setInt(1, id);

                ResultSet rs = stmt.executeQuery();

                // If program in table, add to the list
                if (rs.next()) {
                    // Convert SQL array into string array
                    Array sqlArr = rs.getArray("electives");
                    String[] electivesArr = (String[]) sqlArr.getArray();

                    programs.add(new Program(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("minimum_score"),
                            electivesArr
                    ));
                }
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

        return programs;
    }

    @Override
    public boolean create(Program program) {
        Connection con = null;

        try {
            con = db.getConnection();

            // Query to insert new program into table
            String query = "INSERT INTO programs (name, electives, minimum_score) VALUES(?,?,?)";
            PreparedStatement stmt = con.prepareStatement(query);

            // Create sql array from string array
            Array sqlArr = con.createArrayOf("character varying", program.getElectedSubjectNames());

            // Set fields
            stmt.setString(1, program.getName());
            stmt.setArray(2, sqlArr);
            stmt.setInt(3, program.getMinimumScore());

            stmt.execute();

            // Return true if creation is successful
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
    public Program getLastCreated() {
        Connection con = null;

        try {
            con = db.getConnection();
            // Query to get the last created program
            String query = "SELECT id, name, electives, minimum_score FROM programs ORDER BY id DESC LIMIT 1";
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            // If table is not empty, return program
            if (rs.next()) {
                // Convert SQL array into string array
                Array sqlArr = rs.getArray("electives");
                String[] electivesArr = (String[]) sqlArr.getArray();

                return new Program(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("minimum_score"),
                        electivesArr
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

