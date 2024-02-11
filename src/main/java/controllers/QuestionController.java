package controllers;

import exceptions.InvalidChoiceException;
import exceptions.InvalidSubjectException;
import models.Question;
import repositories.interfaces.IQuestionRepository;

import java.util.*;

public class QuestionController {
    private IQuestionRepository questionRepo;

    public QuestionController(IQuestionRepository questionRepo) {
        this.questionRepo = questionRepo;
    }

    public List<Question> getSubjectQuestions(String subject, boolean multi_answer) {
        try {
            // Get all questions of that subject and type
            List<Question> allQuestions = questionRepo.getAllSubjectQuestions(subject, multi_answer);

            // Shuffle questions
            Collections.shuffle(allQuestions);

            // Return amount of questions that is appropriate for that type
            if (multi_answer) {
                return allQuestions.subList(0, 5);
            } else {
                return allQuestions.subList(0, 5);
            }
        } catch (InvalidSubjectException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Null Pointer Exception: ");
            System.out.println(e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index Out Of Bounds Exception: ");
            System.out.println("There are not enough questions");
        }

        return null;
    }

    public String getQuestionString(Question question) {
        // Letters for each choice
        char[] choiceLetters = new char[]{'a', 'b', 'c', 'd', 'e', 'f'};

        // Get question text, append every choice to it and return it as a string
        StringBuilder questionString = new StringBuilder(question.toString() + "\n\n");

        for (int i = 0; i < question.getNumberOfChoices(); i++) {
            questionString.append(choiceLetters[i]).append(") ").append(question.getChoice(i)).append("\n");
        }

        return questionString.toString();
    }

    public boolean checkAnswerValidity(Question question, String answer) throws InvalidChoiceException {
        // Possible letters choices
        String[] choiceLettersArr = new String[]{"a", "b", "c", "d", "e", "f"};
        List<String> choiceLetters = Arrays.asList(choiceLettersArr);
        choiceLetters = choiceLetters.subList(0, question.getNumberOfChoices());

        if (!choiceLetters.contains(answer.toLowerCase()))
            throw new InvalidChoiceException("Invalid choice");

        return true;
    }

    public boolean checkAnswer(Question question, String answer) {
        char answerChar = answer.charAt(0);

        return question.getChoice(answerChar - 'a').getCorrect();
    }

    public List<String> getSubjectNames() {
        List<String> subjectNames = questionRepo.getSubjectNames(true);
        subjectNames.addAll(questionRepo.getSubjectNames(false));

        return subjectNames;
    }

    public List<String> getSubjectTableNames() {
        List<String> subjects = getSubjectNames();
        questionRepo.convertToTableNames(subjects);

        return subjects;
    }
}
