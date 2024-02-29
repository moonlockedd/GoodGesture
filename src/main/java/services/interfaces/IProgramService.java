package services.interfaces;

import models.Program;
import java.util.List;

public interface IProgramService {
    List<Program> getAll();
    Program getById(int id);
    Program create(Program program);
}
