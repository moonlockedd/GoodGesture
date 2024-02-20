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
    private String name;
    private List<Program> programs;

    public Program getProgram(int index) {
        return programs.get(index);
    }

    public int getNumberOfPrograms() {
        return programs.size();
    }

    private String getAllProgramsString() {
        StringBuilder programsString = new StringBuilder();
        for (Program p : programs) {
            programsString.append(p).append("\n");
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


