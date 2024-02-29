package models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@AllArgsConstructor
@Getter @Setter
public final class University{
    private int id;
    private String name;
    private List<Program> programs;

    public University(String name, List<Program> programs) {
        this.name = name;
        this.programs = programs;
    }

    private String getAllProgramsString() {
        StringBuilder programsString = new StringBuilder();
        for (Program p : getPrograms()) {
            programsString.append(p.toString()).append("\n");
        }

        return programsString.toString();
    }

    @Override
    public String toString() {
        return "University #" + getId() + ":\n" +
                getName() + "\n" +
                "Available programs:" + "\n" +
                getAllProgramsString();
    }
}


