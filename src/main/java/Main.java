import controllers.QuestionController;
import data.PostgresDB;
import data.interfaces.IDB;
import repositories.ChoiceRepository;
import repositories.QuestionRepository;
import repositories.interfaces.IChoiceRepository;
import repositories.interfaces.IQuestionRepository;

public class Main {
    public static void main(String[] args) {
        IDB db = new PostgresDB();
        IChoiceRepository choiceRepo = new ChoiceRepository(db);
        IQuestionRepository questionRepo = new QuestionRepository(db, choiceRepo);
        QuestionController questionController = new QuestionController(questionRepo);
        MyApplication app = new MyApplication(questionController);
        app.start();
    }
}
