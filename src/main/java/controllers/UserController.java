package controllers;

import lombok.AllArgsConstructor;
import models.SubjectScore;
import models.User;
import services.interfaces.IUserService;

import java.util.List;

@AllArgsConstructor
public class UserController {
    private final IUserService userService;

    public String getAll() {
        List<User> users = userService.getAll();

        if (users == null)
            return "No users were found";

        StringBuilder response = new StringBuilder();

        for (User user : users) {
            response.append(user.toString()).append("\n");
        }

        return response.toString();
    }

    public String getById(int id) {
        User user = userService.getById(id);

        if (user == null)
            return "User not found";

        return user.toString();
    }

    public String create(
            String firstName, String lastName,
            String email, String password,
            List<SubjectScore> subjectScores
    ) {
        User user = new User(firstName, lastName, email, password, subjectScores);

        User createdUser = userService.create(user);

        if (createdUser == null)
            return "Failed to create User";
        return "Created User\n" + createdUser;
    }
}
