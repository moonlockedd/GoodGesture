package services.interfaces;

import models.SubjectScore;

import java.util.List;

public interface ISubjectScoreService {
    List<SubjectScore> getAll();
    SubjectScore getById(int id);
    String create(SubjectScore subjectScore);
}
