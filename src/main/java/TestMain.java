import data.PostgresDB;
import data.interfaces.IDataBase;
import models.*;
import repositories.SubjectRepository;
import repositories.interfaces.ISubjectRepository;

import java.util.List;

public class TestMain {
    public static void main(String[] args) {
        IDataBase db = new PostgresDB();
        ISubjectRepository subjectRepo = new SubjectRepository(db);

        List<SubjectScore> subjectScores = subjectRepo.getAllSubjectScores();

        for (SubjectScore subjectScore : subjectScores) {
            System.out.println(subjectScore);
        }
    }
}
