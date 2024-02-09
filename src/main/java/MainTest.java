import controllers.QuestionController;
import data.PostgresDB;
import data.interfaces.IDB;
import models.Choice;
import models.Question;
import repositories.*;

import java.util.List;

public class MainTest {
    public static void main(String[] args) {

        // FOR TESTING PURPOSES

        IDB db = new PostgresDB();
        ChoiceRepository choiceRepo = new ChoiceRepository(db);
        QuestionRepository questionRepo = new QuestionRepository(db, choiceRepo);

        QuestionController questionController = new QuestionController(questionRepo);
        List<Question> qs = questionController.getTypeQuestions("generic", "regular");

        for (Question qn : qs)
            System.out.println(qn);
    }
}
