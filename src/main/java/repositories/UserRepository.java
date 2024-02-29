package repositories;

import data.interfaces.IDataBase;
import exceptions.InvalidNumberOfSubjectsException;
import lombok.AllArgsConstructor;
import models.SubjectScore;
import models.User;
import repositories.interfaces.ISubjectScoreRepository;
import repositories.interfaces.IUserRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class UserRepository implements IUserRepository {
    private final IDataBase db;
    private final ISubjectScoreRepository subjectScoreRepo;

    @Override
    public List<User> getAll() {
        Connection con = null;
        List<User> users = new ArrayList<>();

        try {
            con = db.getConnection();

            String query = "SELECT id,first_name,last_name,email,password," +
                    "subject_score_ids FROM users";
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Array sqlArr = rs.getArray("subject_score_ids");
                Integer[] idArr = (Integer[]) sqlArr.getArray();

                List<SubjectScore> subjectScores = subjectScoreRepo.getAllByIds(idArr);
                if (subjectScores == null) {
                    throw new InvalidNumberOfSubjectsException("Number of subjects must be 5");
                }

                users.add(new User(
                        rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        subjectScores
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (InvalidNumberOfSubjectsException e) {
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

        return users;
    }

    @Override
    public User getById(int id) {
        Connection con = null;

        try {
            con = db.getConnection();

            String query = "SELECT id,first_name,last_name,email,password," +
                    "subject_score_ids FROM users WHERE id=?";
            PreparedStatement stmt = con.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Array sqlArr = rs.getArray("subject_score_ids");
                Integer[] idArr = (Integer[]) sqlArr.getArray();

                List<SubjectScore> subjectScores = subjectScoreRepo.getAllByIds(idArr);
                if (subjectScores == null) {
                    throw new InvalidNumberOfSubjectsException("Number of subjects must be 5");
                }

                return new User(
                        rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        subjectScores
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (InvalidNumberOfSubjectsException e) {
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
    public boolean create(User user) {
        return false;
    }
}
