package org.example.services;

import org.example.database.DatabaseConnection;
import org.example.model.Diagnosis;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;// Diagnosis Service
public class DiagnosisService {
    private final Connection connection = DatabaseConnection.getConnection();

    public void addDiagnosis(Diagnosis diagnosis) {
        String query = "INSERT INTO Diagnosis (diagnosis) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, diagnosis.getDiagnosis());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Diagnosis> getDiagnoses() {
        String query = "SELECT * FROM Diagnosis";
        List<Diagnosis> diagnoses = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Diagnosis diagnosis = new Diagnosis(
                        rs.getInt("diagnosisID"),
                        rs.getString("diagnosis")
                );
                diagnoses.add(diagnosis);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return diagnoses;
    }
}
