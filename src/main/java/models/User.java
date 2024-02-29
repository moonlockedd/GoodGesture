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

    @Override
    public String toString() {
        return "User #" + getId() + ":\n" +
                getFirstName() + " " +
                getLastName() + "\n" +
                "Elected subjects: " +
                getSubjectScores().get(3).getSubject() + " " +
                getSubjectScores().get(4).getSubject();
    }
}
