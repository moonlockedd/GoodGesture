package models;
//import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;


public class Program {
    @Getter @Setter private int id;
    @Getter @Setter String programName;
    @Getter @Setter String uniName;
    @Getter @Setter int minScore;

   public Program(int id, String programName, String uniName, int minScore){
       this.id = id;
       this.programName= programName;
       this.uniName= uniName;
       this.minScore = minScore;
   }

   @Override
    public String toString(){
       return "Program{"+
               "id=" + id +
               ", name='" + programName + '\'' +
               ", university name='" + uniName + '\'' +
               ", minimum score=" + minScore +
               '}';
   }

}
