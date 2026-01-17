package com.edutech.progressive.dao;

import com.edutech.progressive.config.DatabaseConnectionManager;
import com.edutech.progressive.entity.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PatientDAOImpl implements PatientDAO {
    private static final String INSERT_SQL = "INSERT INTO patient (full_name, date_of_birth, contact_number, email, address) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_BY_ID = "SELECT patient_id, full_name, date_of_birth, contact_number, email, address FROM patient WHERE patient_id = ?";
    private static final String UPDATE_SQL = "UPDATE patient SET full_name = ?, date_of_birth = ?, contact_number = ?, email = ?, address = ? WHERE patient_id = ?";
    private static final String DELETE_SQL = "DELETE FROM patient WHERE patient_id = ?";
    private static final String SELECT_ALL = "SELECT patient_id, full_name, date_of_birth, contact_number, email, address FROM patient";

    @Override
    public int addPatient(Patient patient) throws SQLException {
        try (Connection conn = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, patient.getFullName());
            java.sql.Date dob = patient.getDateOfBirth() == null ? null : new java.sql.Date(patient.getDateOfBirth().getTime());
            ps.setDate(2, dob);
            ps.setString(3, patient.getContactNumber());
            ps.setString(4, patient.getEmail());
            ps.setString(5, patient.getAddress());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) return rs.getInt(1);
            }
        }
        return -1;
    }

    @Override
    public Patient getPatientById(int patientId) throws SQLException {
        try (Connection conn = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID)) {
            ps.setInt(1, patientId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Patient p = new Patient();
                    p.setPatientId(rs.getInt("patient_id"));
                    p.setFullName(rs.getString("full_name"));
                    Date d = null;
                    java.sql.Date s = rs.getDate("date_of_birth");
                    if (s != null) d = new Date(s.getTime());
                    p.setDateOfBirth(d);
                    p.setContactNumber(rs.getString("contact_number"));
                    p.setEmail(rs.getString("email"));
                    p.setAddress(rs.getString("address"));
                    return p;
                }
            }
        }
        return null;
    }

    @Override
    public void updatePatient(Patient patient) throws SQLException {
        try (Connection conn = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            ps.setString(1, patient.getFullName());
            java.sql.Date dob = patient.getDateOfBirth() == null ? null : new java.sql.Date(patient.getDateOfBirth().getTime());
            ps.setDate(2, dob);
            ps.setString(3, patient.getContactNumber());
            ps.setString(4, patient.getEmail());
            ps.setString(5, patient.getAddress());
            ps.setInt(6, patient.getPatientId());
            ps.executeUpdate();
        }
    }

    @Override
    public void deletePatient(int patientId) throws SQLException {
        try (Connection conn = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(DELETE_SQL)) {
            ps.setInt(1, patientId);
            ps.executeUpdate();
        }
    }

    @Override
    public List<Patient> getAllPatients() throws SQLException {
        List<Patient> list = new ArrayList<>();
        try (Connection conn = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_ALL);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Patient p = new Patient();
                p.setPatientId(rs.getInt("patient_id"));
                p.setFullName(rs.getString("full_name"));
                java.sql.Date s = rs.getDate("date_of_birth");
                p.setDateOfBirth(s == null ? null : new Date(s.getTime()));
                p.setContactNumber(rs.getString("contact_number"));
                p.setEmail(rs.getString("email"));
                p.setAddress(rs.getString("address"));
                list.add(p);
            }
        }
        return list;
    }
}
