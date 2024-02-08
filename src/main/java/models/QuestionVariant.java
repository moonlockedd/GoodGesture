package models;

public class QuestionVariant {
    // Text content of a variant
    private String content;
    // Variant status (correct or incorrect)
    private boolean correct;

    public QuestionVariant(String content, boolean correct) {
        this.content = content;
        this.correct = correct;
    }

    public String getContent() {
        return content;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    @Override
    public String toString() {
        return "Text content: " + getContent() +
                " " + (isCorrect() ? "correct" : "incorrect");
    }
}
