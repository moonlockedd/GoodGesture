import controllers.ProgramController;
import controllers.SubjectScoreController;
import controllers.UserController;
import data.PostgresDB;
import data.interfaces.IDataBase;
import repositories.ProgramRepository;
import repositories.SubjectScoreRepository;
import repositories.UserRepository;
import repositories.interfaces.IProgramRepository;
import repositories.interfaces.ISubjectScoreRepository;
import repositories.interfaces.IUserRepository;
import services.ProgramService;
import services.SubjectScoreService;
import services.UserService;
import services.interfaces.IProgramService;
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
        IProgramRepository programRepo = new ProgramRepository(db);
        IProgramService programService = new ProgramService(programRepo);
        ProgramController programController = new ProgramController(programService);
        GrantedApplication app = new GrantedApplication(
                subjectScoreController, userController,
                programController
        );
        app.start();
    }
}
