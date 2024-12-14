package org.example.services;

import org.example.database.DatabaseConnection;
import org.example.model.Assessment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AssessmentService {
    private final Connection connection = DatabaseConnection.getConnection();

    public void addAssessment(Assessment assessment) {
        String query = "INSERT INTO Assessment (assessment_name) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, assessment.getAssessmentName());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Assessment> getAssessments() {
        String query = "SELECT * FROM Assessment";
        List<Assessment> assessments = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Assessment assessment = new Assessment(
                        rs.getInt("assessment_ID"),
                        rs.getString("assessment_name")
                );
                assessments.add(assessment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return assessments;
    }
}