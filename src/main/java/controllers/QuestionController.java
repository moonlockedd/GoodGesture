package controllers;

import exceptions.InvalidSubjectException;
import models.Question;
import repositories.QuestionRepository;
import repositories.interfaces.IQuestionRepository;

import javax.security.auth.Subject;
import java.util.*;

public class QuestionController {
    IQuestionRepository questionRepo;

    public QuestionController(IQuestionRepository questionRepo) {
        this.questionRepo = questionRepo;
    }

    public List<Question> getQuestions(String subject, boolean multi_answer) {
        try {
            // Get all questions of that subject and type
            List<Question> allQuestions = questionRepo.getAllQuestions(subject, multi_answer);

            // Shuffle questions
            Collections.shuffle(allQuestions);

            // Return amount of questions that is appropriate for that type
            if (multi_answer) {
                return allQuestions.subList(0, 30);
            } else {
                return allQuestions.subList(0, 10);
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


}
