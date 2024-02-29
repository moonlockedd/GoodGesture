package repositories;

import data.interfaces.IDataBase;
import lombok.AllArgsConstructor;
import models.Program;
import repositories.interfaces.IProgramRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public class ProgramRepository implements IProgramRepository {
    private final IDataBase db;
    @Override
    public List<Program> getAll() {
        Connection con = null;
        List<Program> programs = new ArrayList<>();

        try {
            con = db.getConnection();

            String query = "SELECT id, name, electives, minimum_score FROM programs";
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Program program = new Program(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("minimum_score"),
                        new String[]{rs.getString("electives")});
                programs.add(program);
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

            String query = "SELECT id, name, electives, minimum_score FROM programm WHERE id=?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Program(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("minimum_score"),
                        new String[]{rs.getString("electives")}
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
    public boolean create(Program program) {
        Connection con = null;

        try {
            con = db.getConnection();
            String query = "INSERT INTO programm (name, electives, minimum_score) VALUES(?,?,?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, program.getName());
            stmt.setString(2, Arrays.toString(program.getElectedSubjectNames()));
            stmt.setInt(3, program.getMinimumScore());

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
    public Program getLastCreated() {
        Connection con = null;

        try {
            con = db.getConnection();
            String query = "SELECT id, name, electives, minimum_score FROM programm ORDER BY id DESC LIMIT 1";
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                return new Program(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("minimum_score"),
                        new String[]{rs.getString("electives")}
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

