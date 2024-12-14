package org.example.model;

public class Diagnosis {
    private int diagnosisId;
    private String diagnosis;

    public Diagnosis(int diagnosisId, String diagnosis) {
        this.diagnosisId = diagnosisId;
        this.diagnosis = diagnosis;
    }

    public int getDiagnosisId() { return diagnosisId; }
    public void setDiagnosisId(int diagnosisId) { this.diagnosisId = diagnosisId; }

    public String getDiagnosis() { return diagnosis; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }
}