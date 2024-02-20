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

    public int getTotalScore() {
        int totalScore = 0;

        for (Subject subject : subjects) {
            totalScore += subject.getScore();
        }

        return totalScore;
    }

    public String[] getElectedSubjectNames() {
        String[] electedSubjectNames = new String[2];
        electedSubjectNames[0] = subjects.get(3).getName();
        electedSubjectNames[1] = subjects.get(4).getName();

        return electedSubjectNames;
    }

    @Override
    public String toString() {
        return "User #" + getId() + ":\n" +
                getName() + " " +
                getSurname() + "\n" +
                "Total score: " + getTotalScore() + "\n" +
                "Elected subjects: " +
                getElectedSubjectNames()[0] + ", " +
                getElectedSubjectNames()[1];
    }
}
