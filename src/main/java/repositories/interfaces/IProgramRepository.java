package repositories.interfaces;

import models.Program;
import java.util.List;

public interface IProgramRepository {
    List<Program> getAll();
    Program getById(int id);
    List<Program> getAllByIds(Integer[] ids);
    boolean create(Program program);
    Program getLastCreated();
}
