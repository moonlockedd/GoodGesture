package models;

import java.util.ArrayList;
import java.util.List;

public class TestQuestion {
    private int id;
    // Text content of the question
    private String questionText;
    // Explanation of the answer
    private String explanation;
    // List to store answer variants
    private List<AnswerVariant> answerVariants;

    public TestQuestion() {
        this.answerVariants = new ArrayList<>();
    }

    public TestQuestion(int id, String questionText, String explanation) {
        this();
        this.id = id;
        this.questionText = questionText;
        this.explanation = explanation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    // Add new variants to test question
    public void addQuestionVariant(AnswerVariant answerVariant) {
        this.answerVariants.add(answerVariant);
    }

    public String toString() {
        return getId() + ". " +
                "Question: " + getQuestionText() + "." +
                "Explanation: " + getExplanation() + ".";
    }
}
