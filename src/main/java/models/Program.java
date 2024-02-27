package models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public final class Program {
    private int id;
    private String name;
    private int minimumScore;
    private String[] electedSubjectNames;

    public Program(String name, int minimumScore, String[] electedSubjectNames) {
        this.name = name;
        this.minimumScore = minimumScore;
        this.electedSubjectNames = electedSubjectNames;
    }

    @Override
    public String toString(){
       return "Program #" + getId() + ":\n" +
               getName() + "\n" +
               "Elected subjects: " +
               getElectedSubjectNames()[0] + ", " +
               getElectedSubjectNames()[1] + "\n" +
               "Minimum score: " + getMinimumScore();
   }

}
