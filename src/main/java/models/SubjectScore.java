package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter @Getter
public final class SubjectScore {
    private int id;
    private String subject;
    private int score;

    public SubjectScore(String subject, int score) {
        this.subject = subject;
        this.score = score;
    }

    @Override
    public String toString() {
        return getId() + ": " + getSubject() + " - " + getScore();
    }
}
