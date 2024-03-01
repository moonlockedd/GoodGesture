package repositories;

import data.interfaces.IDataBase;
import lombok.AllArgsConstructor;
import models.SubjectScore;
import repositories.interfaces.ISubjectScoreRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class SubjectScoreRepository implements ISubjectScoreRepository {
    private final IDataBase db;

    @Override
    public List<SubjectScore> getAll() {
        Connection con = null;
        // List to store all SubjectScores
        List<SubjectScore> subjectScores = new ArrayList<>();

        try {
            con = db.getConnection();

            // Query to get all subject scores
            String query = "SELECT id,subject,score FROM subject_scores";
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            // Iterate through result set, create SubjectScore and add it to the list
            while (rs.next()) {
                SubjectScore subjectScore = new SubjectScore(
                        rs.getInt("id"),
                        rs.getString("subject"),
                        rs.getInt("score")
                );
                subjectScores.add(subjectScore);
            }

            return subjectScores;
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

        return subjectScores;
    }

    @Override
    public SubjectScore getById(int id) {
        Connection con = null;

        try {
            con = db.getConnection();

            // Query to get subject score by id
            String query = "SELECT id,subject,score FROM subject_scores WHERE id=?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            // If SubjectScore is in table return it
            if (rs.next()) {
                return new SubjectScore(
                        rs.getInt("id"),
                        rs.getString("subject"),
                        rs.getInt("score")
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
    public List<SubjectScore> getAllByIds(Integer[] ids) {
        Connection con = null;
        List<SubjectScore> subjectScores = new ArrayList<>();

        try {
            con = db.getConnection();

            // Iterate through ids
            for (Integer id : ids) {
                // Query to get subject score with id
                String query = "SELECT id,subject,score FROM subject_scores WHERE id=?";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setInt(1, id);

                ResultSet rs = stmt.executeQuery();

                // If subject score is in table, add it to the list
                if (rs.next()) {
                    subjectScores.add(new SubjectScore(
                            rs.getInt("id"),
                            rs.getString("subject"),
                            rs.getInt("score")
                    ));
                }
            }

            // Return subject scores if their number is suitable
            if (subjectScores.size() == 5)
                return subjectScores;
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
    public boolean create(SubjectScore subjectScore) {
        Connection con = null;

        try {
            con = db.getConnection();

            // Query to insert new subject score into the table
            String query = "INSERT INTO subject_scores (subject,score) VALUES(?,?)";
            PreparedStatement stmt = con.prepareStatement(query);
            // Set fields
            stmt.setString(1, subjectScore.getSubject());
            stmt.setInt(2, subjectScore.getScore());

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
    public SubjectScore getLastCreated() {
        Connection con = null;

        try {
            con = db.getConnection();

            // Query to get the last created subject score
            String query = "SELECT id, subject, score FROM subject_scores " +
                    "ORDER BY id DESC LIMIT 1";
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            // If table is not empty, return SubjectScore
            if (rs.next()) {
                return new SubjectScore(
                        rs.getInt("id"),
                        rs.getString("subject"),
                        rs.getInt("score")
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

        // Return null if table is empty or if exception is thrown
        return null;
    }
}
