package org.example.model;

import java.sql.Date;

public class Patient {
    private int slNo;
    private String name;
    private Date birthDate;
    private String gender;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String maritalStatus;
    private String email;
    private String cellPhone;
    private String emergencyContact;
    private String emergencyPhone;
    private String previousDiagnosis;
    private String referredBy;
    //private String occupation;

    // Constructor, Getters, and Setters
    public Patient(int slNo, String name, Date birthDate, String gender, String address, String city, String state, String zip,
                   String maritalStatus, String email, String cellPhone, String emergencyContact, String emergencyPhone,
                   String previousDiagnosis, String referredBy) {
        this.slNo = slNo;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.maritalStatus = maritalStatus;
        this.email = email;
        this.cellPhone = cellPhone;
        this.emergencyContact = emergencyContact;
        this.emergencyPhone = emergencyPhone;
        this.previousDiagnosis = previousDiagnosis;
        this.referredBy = referredBy;
        //this.occupation = occupation;
    }

    public int getSlNo() { return slNo; }
    public void setSlNo(int slNo) { this.slNo = slNo; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Date getBirthDate() { return birthDate; }
    public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getZip() { return zip; }
    public void setZip(String zip) { this.zip = zip; }

    public String getMaritalStatus() { return maritalStatus; }
    public void setMaritalStatus(String maritalStatus) { this.maritalStatus = maritalStatus; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCellPhone() { return cellPhone; }
    public void setCellPhone(String cellPhone) { this.cellPhone = cellPhone; }

    public String getEmergencyContact() { return emergencyContact; }
    public void setEmergencyContact(String emergencyContact) { this.emergencyContact = emergencyContact; }

    public String getEmergencyPhone() { return emergencyPhone; }
    public void setEmergencyPhone(String emergencyPhone) { this.emergencyPhone = emergencyPhone; }

    public String getPreviousDiagnosis() { return previousDiagnosis; }
    public void setPreviousDiagnosis(String previousDiagnosis) { this.previousDiagnosis = previousDiagnosis; }

    public String getReferredBy() { return referredBy; }
    public void setReferredBy(String referredBy) { this.referredBy = referredBy; }
}