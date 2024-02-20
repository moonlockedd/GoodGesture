package models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@AllArgsConstructor
public final class University{
    @Getter @Setter
    private int id;
    @Getter @Setter
    private String universityName;
    private List<Program> programs;

    public String getAllProgramsString() {
        StringBuilder programsString = new StringBuilder();
        for (Program p : programs) {
            programsString.append(p).append("\n");
        }

        return programsString.toString();
    }

    @Override
    public String toString() {
        return "University #" + getId() + ":" +
                getUniversityName() + "\n" +
                "Available programs:" + "\n" +
                getAllProgramsString();
    }
}


