package models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public final class Program {
    private int id;
    private String programName;
    private int minScore;
    private String[] electedSubjectNames;

    public Program(String programName, int minScore, String[] electedSubjectNames) {
        this.programName = programName;
        this.minScore = minScore;
        this.electedSubjectNames = electedSubjectNames;
    }

    @Override
    public String toString(){
       return "Program #" + getId() + ":\n" +
               getProgramName() + "\n" +
               "Elected subjects: " +
               getElectedSubjectNames()[0] + ", " +
               getElectedSubjectNames()[1] + "\n" +
               "Minimum score: " + getMinScore();
   }

}
