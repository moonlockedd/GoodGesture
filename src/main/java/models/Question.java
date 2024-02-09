package models;

import java.util.ArrayList;
import java.util.List;

public class Question {
    // Text content of the question
    private String questionText;
    // Explanation of the answer
    private String explanation;
    // List to store answer variants
    private List<Choice> choices;

    // Allocate memory for choices
    public Question() {
        this.choices = new ArrayList<>();
    }

    public Question(String questionText, String explanation) {
        this();
        this.questionText = questionText;
        this.explanation = explanation;
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
    public void addQuestionVariant(Choice choice) {
        this.choices.add(choice);
    }

    public String toString() {
        return getQuestionText();
    }
}
