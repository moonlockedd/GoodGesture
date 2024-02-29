package services.interfaces;

import models.User;

import java.util.List;

public interface IUserService {
    List<User> getAll();
    User getById(int id);
    User create(User user);
}
