package repositories.interfaces;

import models.University;

import java.util.List;

public interface IUniversityRepository {
    List<University> getAll();
    University getById(int id);
    boolean create(University university);
    University getLastCreated();
}
