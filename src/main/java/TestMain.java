import data.PostgresDB;
import data.interfaces.IDataBase;
import models.*;
import repositories.SubjectScoreRepository;
import repositories.interfaces.ISubjectScoreRepository;

import java.util.List;

public class TestMain {
    public static void main(String[] args) {
        IDataBase db = new PostgresDB();
        ISubjectScoreRepository subjectRepo = new SubjectScoreRepository(db);

        List<SubjectScore> subjectScores = subjectRepo.getAll();

        for (SubjectScore subjectScore : subjectScores) {
            System.out.println(subjectScore);
        }
    }
}
