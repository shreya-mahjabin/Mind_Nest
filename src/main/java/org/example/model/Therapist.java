package org.example.model;

// Therapist Model
public class Therapist {
    private int therapistId;
    private String name;
    private String specialization;
    private String email;
    private String phone;

    public Therapist(int therapistId, String name, String specialization, String email, String phone) {
        this.therapistId = therapistId;
        this.name = name;
        this.specialization = specialization;
        this.email = email;
        this.phone = phone;
    }

    public int getTherapistId() { return therapistId; }
    public void setTherapistId(int therapistId) { this.therapistId = therapistId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}