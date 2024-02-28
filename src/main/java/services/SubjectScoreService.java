package services;

import lombok.AllArgsConstructor;
import models.SubjectScore;
import repositories.interfaces.ISubjectScoreRepository;
import services.interfaces.ISubjectScoreService;

import java.util.List;

@AllArgsConstructor
public class SubjectScoreService implements ISubjectScoreService {
    private final ISubjectScoreRepository subjectScoreRepo;

    @Override
    public List<SubjectScore> getAll() {
        return subjectScoreRepo.getAll();
    }

    @Override
    public SubjectScore getById(int id) {
        return subjectScoreRepo.getById(id);
    }

    @Override
    public boolean create(SubjectScore subjectScore) {
        return subjectScoreRepo.create(subjectScore);
    }
}
