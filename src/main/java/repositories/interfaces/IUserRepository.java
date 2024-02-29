package repositories.interfaces;

import models.User;

import java.util.List;

public interface IUserRepository {
    List<User> getAll();
    User getById(int id);
    boolean create(User user);
}
