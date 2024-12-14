package org.example;

import org.example.database.DatabaseConnection;

import java.sql.*;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) {
            System.out.println("Exiting due to database connection error.");
            return;
        }
        System.out.println("Database connected successfully!");

        while (true) {
            System.out.println("\n===== Clinic Management System =====");
            System.out.println("1. Add Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Add Assessment");
            System.out.println("4. View All Assessments");
            System.out.println("5. Add Assessment Report");
            System.out.println("6. View Assessment Reports");
            System.out.println("7. Add Diagnosis");
            System.out.println("8. View Diagnoses");
            System.out.println("9. Assign Diagnosis to Patient");
            System.out.println("10. View Patient Diagnoses");
            System.out.println("11. Add Therapist");
            System.out.println("12. View Therapists");
            System.out.println("13. Assign Therapist to Patient");
            System.out.println("14. View Therapist Assignments");
            System.out.println("15. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1 -> addPatient();
                case 2 -> viewPatients();
                case 3 -> addAssessment();
                case 4 -> viewAssessments();
                case 5 -> addAssessmentReport();
                case 6 -> viewAssessmentReports();
                case 7 -> addDiagnosis();
                case 8 -> viewDiagnoses();
                case 9 -> assignDiagnosisToPatient();
                case 10 -> viewPatientDiagnoses();
                case 11 -> addTherapist();
                case 12 -> viewTherapists();
                case 13 -> assignTherapistToPatient();
                case 14 -> viewTherapistAssignments();
                case 15 -> {
                    System.out.println("Exiting... Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // ===================== PATIENT CRUD =====================
    private static void addPatient() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            System.out.print("Enter Sl_No: ");
            int slNo = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Patient Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Birth Date (YYYY-MM-DD): ");
            String birthDate = scanner.nextLine();
            System.out.print("Enter Gender (Male/Female/Other): ");
            String gender = scanner.nextLine();
            System.out.print("Enter Address: ");
            String address = scanner.nextLine();
            System.out.print("Enter City: ");
            String city = scanner.nextLine();
            System.out.print("Enter State: ");
            String state = scanner.nextLine();
            System.out.print("Enter ZIP Code: ");
            String zip = scanner.nextLine();
            System.out.print("Enter Marital Status: Single,'Married','Divorced','Widowed'");
            String maritalStatus = scanner.nextLine();
            System.out.print("Enter Email: ");
            String email = scanner.nextLine();
            System.out.print("Enter Cell Phone: ");
            String phone = scanner.nextLine();
            System.out.print("Enter Emergency Contact Name: ");
            String emergencyContact = scanner.nextLine();
            System.out.print("Enter Emergency Contact Phone: ");
            String emergencyPhone = scanner.nextLine();
            System.out.print("Enter Previous Diagnosis: ");
            String previousDiagnosis = scanner.nextLine();
            System.out.print("Referred By: ");
            String referredBy = scanner.nextLine();

            String sql = "INSERT INTO Patient VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, slNo);
            stmt.setString(2, name);
            stmt.setDate(3, Date.valueOf(birthDate));
            stmt.setString(4, gender);
            stmt.setString(5, address);
            stmt.setString(6, city);
            stmt.setString(7, state);
            stmt.setString(8, zip);
            stmt.setString(9, maritalStatus);
            stmt.setString(10, email);
            stmt.setString(11, phone);
            stmt.setString(12, emergencyContact);
            stmt.setString(13, emergencyPhone);
            stmt.setString(14, previousDiagnosis);
            stmt.setString(15, referredBy);
            stmt.executeUpdate();

            System.out.println("Patient added successfully!");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewPatients() {
        String sql = "SELECT * FROM Patient";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\n--- Patient Records ---");
            while (rs.next()) {
                System.out.println("Sl_No: " + rs.getInt("Sl_No") +
                        ", Name: " + rs.getString("patient_name") +
                        ", Birth Date: " + rs.getDate("birth_date"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ===================== ASSESSMENT CRUD =====================
    private static void addAssessment() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            System.out.print("Enter Assessment ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Assessment Name: ");
            String name = scanner.nextLine();

            String sql = "INSERT INTO Assessment VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.executeUpdate();

            System.out.println("Assessment added successfully!");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewAssessments() {
        String sql = "SELECT * FROM Assessment";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\n--- Assessments ---");
            while (rs.next()) {
                System.out.println("Assessment ID: " + rs.getInt("assessment_ID") +
                        ", Name: " + rs.getString("assessment_name"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ===================== DIAGNOSIS CRUD =====================
    private static void addDiagnosis() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            System.out.print("Enter Diagnosis ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Diagnosis: ");
            String diagnosis = scanner.nextLine();

            String sql = "INSERT INTO Diagnosis VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setString(2, diagnosis);
            stmt.executeUpdate();

            System.out.println("Diagnosis added successfully!");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewDiagnoses() {
        String sql = "SELECT * FROM Diagnosis";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\n--- Diagnoses ---");
            while (rs.next()) {
                System.out.println("Diagnosis ID: " + rs.getInt("diagnosisID") +
                        ", Diagnosis: " + rs.getString("diagnosis"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Continuation of the main class: ClinicDatabase

    // ===================== ASSESSMENT REPORT CRUD =====================
    private static void addAssessmentReport() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            System.out.print("Enter Assessment ID: ");
            int assessmentId = scanner.nextInt();
            System.out.print("Enter Patient Sl_No: ");
            int slNo = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Assessment Date (YYYY-MM-DD): ");
            String assessmentDate = scanner.nextLine();
            System.out.print("Enter Report Date (YYYY-MM-DD): ");
            String reportDate = scanner.nextLine();
            System.out.print("Enter Score: ");
            double score = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Enter Risk Level (Low/Medium/High): ");
            String riskLevel = scanner.nextLine();

            String sql = "INSERT INTO Assessment_Report (assessment_ID, Sl_No, assessment_date, report_date, score, risk_level) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, assessmentId);
            stmt.setInt(2, slNo);
            stmt.setDate(3, Date.valueOf(assessmentDate));
            stmt.setDate(4, Date.valueOf(reportDate));
            stmt.setDouble(5, score);
            stmt.setString(6, riskLevel);
            stmt.executeUpdate();

            System.out.println("Assessment Report added successfully!");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewAssessmentReports() {
        String sql = "SELECT * FROM Assessment_Report";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\n--- Assessment Reports ---");
            while (rs.next()) {
                System.out.println("Assessment ID: " + rs.getInt("assessment_ID") +
                        ", Patient Sl_No: " + rs.getInt("Sl_No") +
                        ", Assessment Date: " + rs.getDate("assessment_date") +
                        ", Report Date: " + rs.getDate("report_date") +
                        ", Score: " + rs.getDouble("score") +
                        ", Risk Level: " + rs.getString("risk_level"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ===================== THERAPIST ASSIGNMENT CRUD =====================
    private static void assignTherapistToPatient() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            System.out.print("Enter Therapist ID: ");
            int therapistId = scanner.nextInt();
            System.out.print("Enter Patient Sl_No: ");
            int slNo = scanner.nextInt();

            String sql = "INSERT INTO Therapist_Assignment (therapist_ID, Sl_No) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, therapistId);
            stmt.setInt(2, slNo);
            stmt.executeUpdate();

            System.out.println("Therapist assigned to patient successfully!");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewTherapistAssignments() {
        String sql = "SELECT TA.therapist_ID, T.therapist_name, TA.Sl_No, P.patient_name " +
                "FROM Therapist_Assignment TA " +
                "JOIN Therapist T ON TA.therapist_ID = T.therapist_ID " +
                "JOIN Patient P ON TA.Sl_No = P.Sl_No";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\n--- Therapist Assignments ---");
            while (rs.next()) {
                System.out.println("Therapist ID: " + rs.getInt("therapist_ID") +
                        ", Therapist Name: " + rs.getString("therapist_name") +
                        ", Patient Sl_No: " + rs.getInt("Sl_No") +
                        ", Patient Name: " + rs.getString("patient_name"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    // ===================== PATIENT-DIAGNOSIS CRUD =====================
    private static void assignDiagnosisToPatient() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            System.out.print("Enter Diagnosis ID: ");
            int diagnosisId = scanner.nextInt();
            System.out.print("Enter Patient Sl_No: ");
            int slNo = scanner.nextInt();

            String sql = "INSERT INTO Patient_Diagnosis (diagnosisID, Sl_No) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, diagnosisId);
            stmt.setInt(2, slNo);
            stmt.executeUpdate();

            System.out.println("Diagnosis assigned to patient successfully!");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewPatientDiagnoses() {
        String sql = "SELECT PD.Sl_No, P.patient_name, PD.diagnosisID, D.diagnosis " +
                "FROM Patient_Diagnosis PD " +
                "JOIN Patient P ON PD.Sl_No = P.Sl_No " +
                "JOIN Diagnosis D ON PD.diagnosisID = D.diagnosisID";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\n--- Patient Diagnoses ---");
            while (rs.next()) {
                System.out.println("Patient Sl_No: " + rs.getInt("Sl_No") +
                        ", Patient Name: " + rs.getString("patient_name") +
                        ", Diagnosis ID: " + rs.getInt("diagnosisID") +
                        ", Diagnosis: " + rs.getString("diagnosis"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ===================== THERAPIST CRUD =====================
    private static void addTherapist() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            System.out.print("Enter Therapist ID: ");
            int therapistId = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Therapist Name: ");
            String therapistName = scanner.nextLine();
            System.out.print("Enter Specialization: ");
            String specialization = scanner.nextLine();
            System.out.print("Enter Therapist Email: ");
            String therapistEmail = scanner.nextLine();
            System.out.print("Enter Therapist Phone: ");
            String therapistPhone = scanner.nextLine();

            String sql = "INSERT INTO Therapist (therapist_ID, therapist_name, specialization, therapist_mail, therapist_phone) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, therapistId);
            stmt.setString(2, therapistName);
            stmt.setString(3, specialization);
            stmt.setString(4, therapistEmail);
            stmt.setString(5, therapistPhone);
            stmt.executeUpdate();

            System.out.println("Therapist added successfully!");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewTherapists() {
        String sql = "SELECT * FROM Therapist";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\n--- Therapists ---");
            while (rs.next()) {
                System.out.println("Therapist ID: " + rs.getInt("therapist_ID") +
                        ", Name: " + rs.getString("therapist_name") +
                        ", Specialization: " + rs.getString("specialization") +
                        ", Email: " + rs.getString("therapist_mail") +
                        ", Phone: " + rs.getString("therapist_phone"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


}
