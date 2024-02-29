package services;

import lombok.AllArgsConstructor;
import models.User;
import repositories.interfaces.IUserRepository;
import services.interfaces.IUserService;

import java.util.List;

@AllArgsConstructor
public class UserService implements IUserService {
    private final IUserRepository userRepo;
    @Override
    public List<User> getAll() {
        List<User> users = userRepo.getAll();

        if (users.isEmpty())
            return null;
        return users;
    }

    @Override
    public User getById(int id) {
        return userRepo.getById(id);
    }

    @Override
    public User create(User user) {
        boolean created = userRepo.create(user);

        if (created)
            return userRepo.getLastCreated();
        return null;
    }
}
