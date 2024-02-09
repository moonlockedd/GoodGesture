package models;

public class Choice {
    // Text content of a choice
    private String choiceText;
    // Choice status (correct or incorrect)
    private boolean correct;

    public Choice(String choiceText, boolean correct) {
        this.choiceText = choiceText;
        this.correct = correct;
    }

    public String getChoiceText() {
        return choiceText;
    }

    public void setChoiceText(String choiceText) {
        this.choiceText = choiceText;
    }

    public boolean getCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    @Override
    public String toString() {
        return getChoiceText();
    }
}
