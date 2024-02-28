import controllers.SubjectScoreController;
import data.PostgresDB;
import data.interfaces.IDataBase;
import repositories.SubjectScoreRepository;
import repositories.interfaces.ISubjectScoreRepository;
import services.SubjectScoreService;
import services.interfaces.ISubjectScoreService;

public class TestMain {
    public static void main(String[] args) {
        IDataBase db = new PostgresDB();
        ISubjectScoreRepository subjectRepo = new SubjectScoreRepository(db);
        ISubjectScoreService subjectScoreService = new SubjectScoreService(subjectRepo);
        SubjectScoreController subjectScoreController = new SubjectScoreController(subjectScoreService);
        GrantedApplication app = new GrantedApplication(subjectScoreController);
        app.start();
    }
}
