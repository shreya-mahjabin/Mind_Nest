package org.example.model;

public class Assessment {
    private int assessmentId;
    private String assessmentName;

    public Assessment(int assessmentId, String assessmentName) {
        this.assessmentId = assessmentId;
        this.assessmentName = assessmentName;
    }

    public int getAssessmentId() { return assessmentId; }
    public void setAssessmentId(int assessmentId) { this.assessmentId = assessmentId; }

    public String getAssessmentName() { return assessmentName; }
    public void setAssessmentName(String assessmentName) { this.assessmentName = assessmentName; }
}