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
        List<SubjectScore> subjectScores = new ArrayList<>();

        try {
            con = db.getConnection();

            String query = "SELECT id,subject,score FROM subject_scores";
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);


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

            String query = "SELECT id,subject,score FROM subject_scores WHERE id=?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

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
    public boolean create(SubjectScore subjectScore) {
        Connection con = null;

        try {
            con = db.getConnection();

            String query = "INSERT INTO subject_scores (subject,score) VALUES(?,?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, subjectScore.getSubject());
            stmt.setInt(2, subjectScore.getScore());

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
}
