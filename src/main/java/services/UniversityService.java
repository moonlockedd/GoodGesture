package services;

import lombok.AllArgsConstructor;
import models.University;
import repositories.interfaces.IUniversityRepository;
import services.interfaces.IUniversityService;

import java.util.List;

@AllArgsConstructor
public class UniversityService implements IUniversityService {
    private final IUniversityRepository universityRepo;
    @Override
    public List<University> getAll() {
        return universityRepo.getAll();
    }

    @Override
    public University getById(int id) {
        return universityRepo.getById(id);
    }

    @Override
    public University create(University university) {
        boolean created = universityRepo.create(university);

        if (created)
            return universityRepo.getLastCreated();
        return null;
    }
}
