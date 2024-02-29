package repositories.interfaces;

import models.SubjectScore;

import java.util.List;

public interface ISubjectScoreRepository {
    List<SubjectScore> getAll();
    SubjectScore getById(int id);
    List<SubjectScore> getAllByIds(Integer[] ids);
    boolean create(SubjectScore subjectScore);
    SubjectScore getLastCreated();
}
