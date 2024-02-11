package repositories.interfaces;

import exceptions.InvalidSubjectException;
import models.Question;

import java.util.List;

public interface IQuestionRepository {
    Question getQuestion(String subject, int id) throws InvalidSubjectException;
    List<Question> getAllSubjectQuestions(String subject, boolean multi_answer) throws InvalidSubjectException;
    List<String> getSubjectNames(boolean elective);
    void convertToTableNames(List<String> subjects);
}
