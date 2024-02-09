package models;

import java.util.ArrayList;
import java.util.List;

public class Question {
    // Text content of the question
    private String questionText;
    // Explanation of the answer
    private String explanation;
    // List to store question choices
    private final List<Choice> choices;

    public Question(String questionText, String explanation, List<Choice> choices) {
        this.questionText = questionText;
        this.explanation = explanation;
        this.choices = choices;
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

    public int getNumberOfChoices() {
        return this.choices.size();
    }

    public Choice getChoice(int index) {
        return choices.get(index);
    }

    public String toString() {
        return getQuestionText();
    }
}
