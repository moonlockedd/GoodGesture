import controllers.QuestionController;
import data.PostgresDB;
import data.interfaces.IDB;
import exceptions.InvalidChoiceException;
import models.Question;
import repositories.*;

import java.util.List;
import java.util.Scanner;

public class MainTest {
    /*public static void main(String[] args) {

        // FOR TESTING PURPOSES
        Scanner sc = new Scanner(System.in);
        IDB db = new PostgresDB();
        ChoiceRepository choiceRepo = new ChoiceRepository(db);
        QuestionRepository questionRepo = new QuestionRepository(db, choiceRepo);

        QuestionController questionController = new QuestionController(questionRepo);
        List<Question> qs = questionController.getSubjectQuestions("history_of_kazakhstan", false);

        System.out.println("--------------------------------------------------------");
        int correctQuestions = 0;
        for (Question qn : qs) {
            System.out.println(questionController.getQuestionString(qn));
            String answer;
            // Check validity
            while (true) {
                try {
                    answer = sc.nextLine();
                    if (questionController.checkAnswerValidity(qn, answer))
                        break;
                } catch (InvalidChoiceException e) {
                    System.out.println(e.getMessage());
                }
            }

            if (questionController.checkAnswer(qn, answer))
                correctQuestions++;
        }

        System.out.println(correctQuestions);
    }*/
}
