import controllers.QuestionController;
import exceptions.InvalidChoiceException;
import models.Question;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MyApplication {
    private final QuestionController questionController;
    private final Scanner scanner;

    public MyApplication(QuestionController questionController) {
        this.questionController = questionController;
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("Welcome to GrantEd!");
            System.out.println("Select option: ");
            System.out.println("1. Try one test");
            System.out.println("0. Exit");

            try {
                System.out.println("Enter option (1 or 0): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    chooseSubjectMenu();
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be an integer");
                scanner.nextLine(); // to ignore incorrect input
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("------------------------------------------------");
        }
    }

    public void chooseSubjectMenu() {
        List<String> subjectNames = questionController.getSubjectNames();

        for (int i = 0; i < subjectNames.size(); i++) {
            System.out.println((i + 1) + ". " + subjectNames.get(i));
        }
        System.out.println(0 + ". Return");

        System.out.println("Select a subject (1-" + subjectNames.size() + ") or return (0):");
        int option;
        while (true) {
            try {
                option = scanner.nextInt();
                if (option < 0 || option > subjectNames.size()) {
                    System.out.println("Invalid selection");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be an integer");
            }
        }

        if (option != 0) {
            List<String> subjectTableNames = questionController.getSubjectTableNames();
            System.out.println("------------------------------------------------");
            System.out.println(subjectNames.get(option - 1) + "\n");
            startTest(subjectTableNames.get(option - 1));
        }
    }

    public void startTest(String subject) {
        List<Question> questions = questionController.getSubjectQuestions(subject, false);

        int correctQuestions = 0;
        int questionCount = 1;

        for (Question question : questions) {
            System.out.println(questionCount + ". " + questionController.getQuestionString(question));
            String answer;
            // Check validity
            while (true) {
                try {
                    answer = scanner.nextLine();
                    if (questionController.checkAnswerValidity(question, answer))
                        break;
                } catch (InvalidChoiceException e) {
                    System.out.println(e.getMessage());
                }
            }

            if (questionController.checkAnswer(question, answer))
                correctQuestions++;
            questionCount++;
        }

        System.out.println("Total: " + correctQuestions + "/" + questions.size());
    }
}
