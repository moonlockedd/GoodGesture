package models;

public class AnswerVariant {
    private int id;
    // Text content of a variant
    private String answerVariantText;
    // Variant status (correct or incorrect)
    private boolean correct;

    public AnswerVariant(int id, String answerVariantText, boolean correct) {
        this.id = id;
        this.answerVariantText = answerVariantText;
        this.correct = correct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswerVariantText() {
        return answerVariantText;
    }

    public void setAnswerVariantText(String answerVariantText) {
        this.answerVariantText = answerVariantText;
    }

    public boolean getCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    @Override
    public String toString() {
        return getId() + ". " +
                "Text content: " + getAnswerVariantText() +
                " " + (getCorrect() ? "correct" : "incorrect");
    }
}
