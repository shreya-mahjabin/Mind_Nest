package org.example.services;

import org.example.database.DatabaseConnection;
import org.example.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReportService {
    private final Connection connection = DatabaseConnection.getConnection();

    public void addReport(Report report) {
        String query = "INSERT INTO Assessment_Report (assessment_ID, Sl_No, assessment_date, report_date, score, risk_level) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, report.getAssessmentId());
            stmt.setInt(2, report.getSlNo());
            stmt.setDate(3, report.getAssessmentDate());
            stmt.setDate(4, report.getReportDate());
            stmt.setDouble(5, report.getScore());
            stmt.setString(6, report.getRiskLevel());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Report> getReports() {
        String query = "SELECT * FROM Assessment_Report";
        List<Report> reports = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Report report = new Report(
                        rs.getInt("assessment_ID"),
                        rs.getInt("Sl_No"),
                        rs.getDate("assessment_date"),
                        rs.getDate("report_date"),
                        rs.getDouble("score"),
                        rs.getString("risk_level")
                );
                reports.add(report);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reports;
    }
}