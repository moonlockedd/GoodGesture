package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter @AllArgsConstructor
public final class Subject {
    private String name;
    private int score;

    @Override
    public String toString() {
        return getName() + ": " + getScore();
    }
}
