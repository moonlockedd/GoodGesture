package repositories;

import data.interfaces.IDB;
import models.Choice;
import repositories.interfaces.IChoiceRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChoiceRepository implements IChoiceRepository {
    private final IDB db;

    public ChoiceRepository(IDB db) {
        this.db = db;
    }

    @Override
    public List<Choice> getChoices(int id) {
        Connection con = null;

        try {
            // Establish connection
            con = db.getConnection();

            // Allocate memory to list storing question choices
            List<Choice> choices = new ArrayList<>();

            // Prepare sql statement and execute it
            String sql = "SELECT correct_choices, incorrect_choices FROM questions " +
                    "WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                // Get Array object of correct choices
                Array correctChoicesArr = rs.getArray("correct_choices");
                // Get Array object of incorrect choices
                Array incorrectChoicesArr = rs.getArray("incorrect_choices");

                // Convert both incorrect and correct to string arrays
                String[] correctChoices = (String[]) correctChoicesArr.getArray();
                String[] incorrectChoices = (String[]) incorrectChoicesArr.getArray();

                // Add choices to choices ArrayList
                for (String choiceText : correctChoices) {
                    Choice choice = new Choice(choiceText, true);
                    choices.add(choice);
                }
                for (String choiceText : incorrectChoices) {
                    Choice choice = new Choice(choiceText, false);
                    choices.add(choice);
                }
            }

            // Shuffle choices
            Collections.shuffle(choices);

            return choices;

        } catch (SQLException e) {
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
