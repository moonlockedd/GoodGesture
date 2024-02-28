package services.interfaces;

import models.SubjectScore;

import java.util.List;

public interface ISubjectScoreService {
    List<SubjectScore> getAll();
    SubjectScore getById(int id);
    SubjectScore create(SubjectScore subjectScore);
}
