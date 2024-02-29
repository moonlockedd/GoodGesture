package repositories.interfaces;

import models.User;

import java.util.List;

public interface IUserRepository {
    List<User> getAll();
    User getById(int id);
    User getLastCreated();
    boolean create(User user);
}
