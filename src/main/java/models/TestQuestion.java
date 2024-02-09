package models;

import java.util.ArrayList;

public class TestQuestion {
    private int id;
    private String question;
    private String explanation;
    private ArrayList<QuestionVariant> variants;
    public TestQuestion(){

    }
    public TestQuestion(int id,String question,String explanation){

    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
                "Explanation " + getExplanation()+
                "Id=" + getId();
    }

}
