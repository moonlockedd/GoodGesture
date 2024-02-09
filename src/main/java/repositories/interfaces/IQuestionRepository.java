package repositories.interfaces;

import models.Question;

public interface IQuestionRepository {
    Question getQuestion(int id);
    void printQuestion(Question question);
}
