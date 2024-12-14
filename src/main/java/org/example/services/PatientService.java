package org.example.services;

import org.example.database.DatabaseConnection;
import org.example.model.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientService {
    private final Connection connection = DatabaseConnection.getConnection();

    public void addPatient(Patient patient) {
        String query = "INSERT INTO Patient (patient_name, birth_date, gender, address, city, state, zip, marital_status, email, " +
                "cell_phone, emergency_contact, emergency_phone, previous_diagnosis, referred_by) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, patient.getName());
            stmt.setDate(2, patient.getBirthDate());
            stmt.setString(3, patient.getGender());
            stmt.setString(4, patient.getAddress());
            stmt.setString(5, patient.getCity());
            stmt.setString(6, patient.getState());
            stmt.setString(7, patient.getZip());
            stmt.setString(8, patient.getMaritalStatus());
            stmt.setString(9, patient.getEmail());
            stmt.setString(10, patient.getCellPhone());
            stmt.setString(11, patient.getEmergencyContact());
            stmt.setString(12, patient.getEmergencyPhone());
            stmt.setString(13, patient.getPreviousDiagnosis());
            stmt.setString(14, patient.getReferredBy());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Patient> getAllPatients() {
        List<Patient> patients = new ArrayList<>();
        String query = "SELECT * FROM Patient";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Patient patient = new Patient(
                        rs.getInt("Sl_No"),
                        rs.getString("patient_name"),
                        rs.getDate("birth_date"),
                        rs.getString("gender"),
                        rs.getString("address"),
                        rs.getString("city"),
                        rs.getString("state"),
                        rs.getString("zip"),
                        rs.getString("marital_status"),
                        rs.getString("email"),
                        rs.getString("cell_phone"),
                        rs.getString("emergency_contact"),
                        rs.getString("emergency_phone"),
                        rs.getString("previous_diagnosis"),
                        rs.getString("referred_by")
                );
                patients.add(patient);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching patients: " + e.getMessage());
        }
        return patients;
    }
}
