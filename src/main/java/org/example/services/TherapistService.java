package org.example.services;

import org.example.database.DatabaseConnection;
import org.example.model.Patient;
import org.example.model.Therapist;
import org.example.model.Assessment;
import org.example.model.Diagnosis;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Therapist Service
public class TherapistService {
    private final Connection connection = DatabaseConnection.getConnection();

    public void addTherapist(Therapist therapist) {
        String query = "INSERT INTO Therapist (therapist_name, specialization, therapist_mail, therapist_phone) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, therapist.getName());
            stmt.setString(2, therapist.getSpecialization());
            stmt.setString(3, therapist.getEmail());
            stmt.setString(4, therapist.getPhone());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Therapist> getTherapists() {
        String query = "SELECT * FROM Therapist";
        List<Therapist> therapists = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Therapist therapist = new Therapist(
                        rs.getInt("therapist_ID"),
                        rs.getString("therapist_name"),
                        rs.getString("specialization"),
                        rs.getString("therapist_mail"),
                        rs.getString("therapist_phone")
                );
                therapists.add(therapist);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return therapists;
    }
}