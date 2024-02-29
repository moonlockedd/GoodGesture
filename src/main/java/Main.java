import controllers.SubjectScoreController;
import controllers.UserController;
import data.PostgresDB;
import data.interfaces.IDataBase;
import repositories.SubjectScoreRepository;
import repositories.UserRepository;
import repositories.interfaces.ISubjectScoreRepository;
import repositories.interfaces.IUserRepository;
import services.SubjectScoreService;
import services.UserService;
import services.interfaces.ISubjectScoreService;
import services.interfaces.IUserService;

public class Main {
    public static void main(String[] args) {
        IDataBase db = new PostgresDB();
        ISubjectScoreRepository subjectRepo = new SubjectScoreRepository(db);
        ISubjectScoreService subjectScoreService = new SubjectScoreService(subjectRepo);
        SubjectScoreController subjectScoreController = new SubjectScoreController(subjectScoreService);
        IUserRepository userRepo = new UserRepository(db, subjectRepo);
        IUserService userService = new UserService(userRepo);
        UserController userController = new UserController(userService);
        GrantedApplication app = new GrantedApplication(
                subjectScoreController, userController
        );
        app.start();
    }
}
