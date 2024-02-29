package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter @Setter
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private List<SubjectScore> subjectScores;

    public User(
            String firstName, String lastName,
            String email, String password,
            List<SubjectScore> subjectScores
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.subjectScores = subjectScores;
    }

    @Override
    public String toString() {
        return "User #" + getId() + ":\n" +
                getFirstName() + " " +
                getLastName() + "\n" +
                getEmail() + "\n" +
                getPassword() + "\n" +
                "Elected subjects:\n" +
                getSubjectScores().get(3).getSubject() + ", " +
                getSubjectScores().get(4).getSubject();
    }
}
