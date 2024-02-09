package repositories.interfaces;

import models.Question;

import java.util.List;

public interface IQuestionRepository {
    Question getQuestion(int id);
    List<Question> getAllQuestions(String subject, String type);
}
