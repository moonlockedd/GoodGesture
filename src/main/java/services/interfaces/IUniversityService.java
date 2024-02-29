package services.interfaces;

import models.University;

import java.util.List;

public interface IUniversityService {
    List<University> getAll();
    University getById(int id);
    University create(University university);
}
