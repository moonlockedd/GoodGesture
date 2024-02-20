package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
public class User {
    @Setter @Getter
    private int id;
    @Setter @Getter
    private String name;
    @Setter @Getter
    private String surname;
    @Setter @Getter
    private String email;
    @Setter @Getter
    private String phoneNumber;
    private List<Subject> subjects;

    public Subject getSubject(int index) {
        return subjects.get(index);
    }

    public int getNumberOfSubjects() {
        return subjects.size();
    }

    @Override
    public String toString() {
        return "User #" + getId() + ":\n" +
                getName() + " " +
                getSurname() + "\n" +
                "Elected subjects: " +
                getSubject(3).getName() + " " +
                getSubject(4).getName();
    }
}
