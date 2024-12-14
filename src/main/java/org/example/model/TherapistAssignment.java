package org.example.model;

public class TherapistAssignment {
    private int therapistId;
    private int slNo;

    public TherapistAssignment(int therapistId, int slNo) {
        this.therapistId = therapistId;
        this.slNo = slNo;
    }

    public int getTherapistId() { return therapistId; }
    public void setTherapistId(int therapistId) { this.therapistId = therapistId; }

    public int getSlNo() { return slNo; }
    public void setSlNo(int slNo) { this.slNo = slNo; }
}

