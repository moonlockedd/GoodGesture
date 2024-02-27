package repositories.interfaces;

import models.SubjectScore;

import java.util.List;

public interface ISubjectRepository {
    List<SubjectScore> getAllSubjectScores();
    SubjectScore getSubjectScoreById(int id);
    boolean createSubjectScore(SubjectScore subjectScore);
}
