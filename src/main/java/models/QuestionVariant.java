package models;

public class QuestionVariant {
    private int id;
    // Text content of a variant
    private String content;
    // Variant status (correct or incorrect)
    private boolean correct;

    public QuestionVariant(int id, String content, boolean correct) {
        this.id = id;
        this.content = content;
        this.correct = correct;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
        return "Text content: " + getContent() + "id=" + getId() +
                " " + (isCorrect() ? "correct" : "incorrect");
    }
}
