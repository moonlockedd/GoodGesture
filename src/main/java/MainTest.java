import data.PostgresDB;
import data.interfaces.IDB;
import models.Choice;
import models.Question;
import repositories.ChoiceRepository;
import repositories.QuestionRepository;

public class MainTest {
    public static void main(String[] args) {
        IDB db = new PostgresDB();
        ChoiceRepository choiceRepo = new ChoiceRepository(db);
        QuestionRepository questionRepo = new QuestionRepository(db, choiceRepo);
        Question q = questionRepo.getQuestion(2, "generic");
        Choice c = q.getChoice(0);
        System.out.println(c.getChoiceText());
    }
}
