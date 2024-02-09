package repositories.interfaces;

import models.Choice;

import java.util.List;

public interface IChoiceRepository {
    List<Choice> getChoices(int id, String subject);
}
