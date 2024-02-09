package repositories;

import data.interfaces.IDB;
import models.Choice;
import models.Question;
import repositories.interfaces.IChoiceRepository;
import repositories.interfaces.IQuestionRepository;

import java.sql.*;
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
        Connection con = null;

        try {
            con = db.getConnection();
            List<Choice> choices = choiceRepo.getChoices(id);

            String sql = "SELECT question_text, explanation FROM questions WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);

            ResultSet rs = st.executeQuery();

            if (rs.next() && choices != null) {
                return new Question(
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

                if (con != null)
                    con.close();

            } catch (SQLException e) {

                System.out.println("Could not close connection");
                System.out.println(e.getMessage());

            }
        }

        return null;
    }

    @Override
    public void printQuestion(Question question) {
    }
}
