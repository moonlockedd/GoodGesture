package models;
//import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@AllArgsConstructor
@Getter @Setter
public class Program {
    private int id;
    private String programName;
    private String universityName;
    private int minScore;
    private String[] electedSubjectNames;

   @Override
    public String toString(){
       return "Program{"+
               "id=" + id +
               ", name='" + programName + '\'' +
               ", electedSubjectNames=" + Arrays.toString(electedSubjectNames) +
               ", university name='" + universityName + '\'' +
               ", minimum score=" + minScore +
               '}';
   }

}
