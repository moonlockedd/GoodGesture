package controllers;

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

    public List<Question> getTypeQuestions(String subject, String type) {
        // Get all questions of that subject and type
        List<Question> allQuestions = questionRepo.getAllQuestions(subject, type);

        // Shuffle questions
        Collections.shuffle(allQuestions);

        // Return amount of questions that is appropriate for that type
        if (type.equals("regular")) {
            return allQuestions.subList(0, 30);
        } else if (type.equals("multiple")) {
            return allQuestions.subList(0, 10);
        }

        return null;
    }

    public List<String> getProfileSubjects() {
        String[] subjectsArr = new String[]{
                "Mathematics","Qazaq Lang","Russian Lang",
                "Physics","Chemistry","Biology","German Lang",
                "Geography","Russian Lang","World History",
                "English Lang","French Lang","Law","Informatics"
        };

        return new ArrayList<>(Arrays.asList(subjectsArr));
    }
}
