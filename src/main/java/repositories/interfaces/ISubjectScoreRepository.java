package repositories.interfaces;

import models.SubjectScore;

import java.util.List;

public interface ISubjectScoreRepository {
    List<SubjectScore> getAll();
    SubjectScore getById(int id);
    boolean create(SubjectScore subjectScore);
}
