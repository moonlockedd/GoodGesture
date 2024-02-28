package controllers;

import lombok.AllArgsConstructor;
import models.SubjectScore;
import services.interfaces.ISubjectScoreService;

import java.util.List;

@AllArgsConstructor
public class SubjectScoreController {
    private final ISubjectScoreService subjectScoreService;

    public String getAll() {
        // Get all SubjectScores
        List<SubjectScore> subjectScores = subjectScoreService.getAll();
        StringBuilder response = new StringBuilder();

        // Append all SubjectScore string representations to response
        for (SubjectScore subjectScore : subjectScores) {
            response.append(subjectScore.toString()).append("\n");
        }

        return response.toString();
    }

    public String getById(int id) {
        // Get SubjectScore with given id
        SubjectScore subjectScore = subjectScoreService.getById(id);

        // If SubjectScore does not exist, return appropriate response
        if (subjectScore == null)
            return "Subject Score was not found";
        return subjectScore.toString();
    }

    public String create(String subject, int score) {
        // Instantiate new SubjectScore
        SubjectScore subjectScore = new SubjectScore(subject, score);

        // Return appropriate response
        boolean created = subjectScoreService.create(subjectScore);
        if (created)
            return "Created Subject Score";
        return "Failed to create Subject Score";
    }
}
