package services;

import lombok.AllArgsConstructor;
import models.Program;
import repositories.interfaces.IProgramRepository;
import services.interfaces.IProgramService;

import java.util.List;

@AllArgsConstructor
public class ProgramService implements IProgramService {
    private final IProgramRepository programRepo;

    @Override
    public List<Program> getAll() {
        return programRepo.getAll();
    }

    @Override
    public Program getById(int id) {
        return programRepo.getById(id);
    }

    @Override
    public Program create(Program program) {
        // Check if created
        boolean created = programRepo.create(program);

        if (created)
            return programRepo.getLastCreated();
        // Return null if failed to create
        return null;
    }
}
