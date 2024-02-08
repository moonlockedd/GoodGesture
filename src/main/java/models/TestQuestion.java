package models;

import java.util.ArrayList;

public class TestQuestion {
    private String question;
    private String explanation;
    private ArrayList<QuestionVariant> variants;
    public TestQuestion(){

    }
    public TestQuestion(String question,String explanation){

    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String toString() {
        return "Question: " + getQuestion() +
                "Explanation " + getExplanation();
    }


}
