package org.example.model;

import java.sql.Date;

// Report Model
public class Report {
    private int assessmentId;
    private int slNo;
    private Date assessmentDate;
    private Date reportDate;
    private double score;
    private String riskLevel;

    public Report(int assessmentId, int slNo, Date assessmentDate, Date reportDate, double score, String riskLevel) {
        this.assessmentId = assessmentId;
        this.slNo = slNo;
        this.assessmentDate = assessmentDate;
        this.reportDate = reportDate;
        this.score = score;
        this.riskLevel = riskLevel;
    }

    public int getAssessmentId() { return assessmentId; }
    public void setAssessmentId(int assessmentId) { this.assessmentId = assessmentId; }

    public int getSlNo() { return slNo; }
    public void setSlNo(int slNo) { this.slNo = slNo; }

    public Date getAssessmentDate() { return assessmentDate; }
    public void setAssessmentDate(Date assessmentDate) { this.assessmentDate = assessmentDate; }

    public Date getReportDate() { return reportDate; }
    public void setReportDate(Date reportDate) { this.reportDate = reportDate; }

    public double getScore() { return score; }
    public void setScore(double score) { this.score = score; }

    public String getRiskLevel() { return riskLevel; }
    public void setRiskLevel(String riskLevel) { this.riskLevel = riskLevel; }
}

