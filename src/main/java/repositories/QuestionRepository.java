package repositories;

import data.interfaces.IDB;
import models.Choice;
import models.Question;
import repositories.interfaces.IChoiceRepository;
import repositories.interfaces.IQuestionRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionRepository implements IQuestionRepository {
    private final IDB db;
    private final IChoiceRepository choiceRepo;

    public QuestionRepository(IDB db, ChoiceRepository choiceRepo) {
        this.db = db;
        this.choiceRepo = choiceRepo;
    }

    @Override
    public Question getQuestion(int id) {
        Question question = null;
        Connection con = null;

        try {
            // Establish connection
            con = db.getConnection();

            // Prepare sql statement and execute it
            String sql = "SELECT question_text, explanation FROM questions WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                // List to store question choices
                List<Choice> choices = choiceRepo.getChoices(id);
                question = new Question(
                        rs.getString("question_text"),
                        rs.getString("explanation"),
                        choices
                );
            }

        } catch (SQLException e) {
            System.out.println("SQL Exception:");
            System.out.println(e.getMessage());
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Could not close connection");
                System.out.println(e.getMessage());
            }
        }

        return question;
    }

    @Override
    public List<Question> getAllQuestions(String subject, String type) {
        Connection con = null;

        try {
            // Establish connection
            con = db.getConnection();

            // ArrayList to store questions
            List<Question> questions = new ArrayList<>();

            // Prepare SQL statement and execute it
            String sql = "SELECT id, question_text, explanation FROM questions WHERE subject=? AND type=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, subject);
            st.setString(2, type);

            ResultSet rs = st.executeQuery();

            // Iterate through the result set
            while (rs.next()) {
                // Get choices for the current question id and subject
                List<Choice> choices = choiceRepo.getChoices(rs.getInt("id"));

                // Create a new Question object
                Question question = new Question(
                        rs.getString("question_text"),
                        rs.getString("explanation"),
                        choices
                );

                // Add Question object to a list
                questions.add(question);
            }

            return questions;

        } catch (Exception e) {
            System.out.println("SQL Exception: ");
            System.out.println(e.getMessage());
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Could not close connection");
                System.out.println(e.getMessage());
            }
        }

        return null;
    }

}
