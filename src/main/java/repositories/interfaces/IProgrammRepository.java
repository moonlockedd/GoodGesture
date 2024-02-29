package repositories.interfaces;

import models.Program;
import java.util.List;

public interface IProgrammRepository {
    List<Program> getAll();
    Program getById(int id);
    boolean create(Program program);
    Program getLastCreated();
}
