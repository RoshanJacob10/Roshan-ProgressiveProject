package com.edutech.progressive.dao;

import com.edutech.progressive.config.DatabaseConnectionManager;
import com.edutech.progressive.entity.Clinic;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClinicDAOImpl implements ClinicDAO {
    private static final String INSERT_SQL = "INSERT INTO clinic (clinic_name, location, doctor_id, contact_number, established_year) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_BY_ID = "SELECT clinic_id, clinic_name, location, doctor_id, contact_number, established_year FROM clinic WHERE clinic_id = ?";
    private static final String UPDATE_SQL = "UPDATE clinic SET clinic_name = ?, location = ?, doctor_id = ?, contact_number = ?, established_year = ? WHERE clinic_id = ?";
    private static final String DELETE_SQL = "DELETE FROM clinic WHERE clinic_id = ?";
    private static final String SELECT_ALL = "SELECT clinic_id, clinic_name, location, doctor_id, contact_number, established_year FROM clinic";

    @Override
    public int addClinic(Clinic clinic) throws SQLException {
        try (Connection conn = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, clinic.getClinicName());
            ps.setString(2, clinic.getLocation());
            ps.setInt(3, clinic.getDoctorId());
            ps.setString(4, clinic.getContactNumber());
            ps.setInt(5, clinic.getEstablishedYear());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) return rs.getInt(1);
            }
        }
        return -1;
    }

    @Override
    public Clinic getClinicById(int clinicId) throws SQLException {
        try (Connection conn = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID)) {
            ps.setInt(1, clinicId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Clinic c = new Clinic();
                    c.setClinicId(rs.getInt("clinic_id"));
                    c.setClinicName(rs.getString("clinic_name"));
                    c.setLocation(rs.getString("location"));
                    c.setDoctorId(rs.getInt("doctor_id"));
                    c.setContactNumber(rs.getString("contact_number"));
                    c.setEstablishedYear(rs.getInt("established_year"));
                    return c;
                }
            }
        }
        return null;
    }

    @Override
    public void updateClinic(Clinic clinic) throws SQLException {
        try (Connection conn = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            ps.setString(1, clinic.getClinicName());
            ps.setString(2, clinic.getLocation());
            ps.setInt(3, clinic.getDoctorId());
            ps.setString(4, clinic.getContactNumber());
            ps.setInt(5, clinic.getEstablishedYear());
            ps.setInt(6, clinic.getClinicId());
            ps.executeUpdate();
        }
    }

    @Override
    public void deleteClinic(int clinicId) throws SQLException {
        try (Connection conn = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(DELETE_SQL)) {
            ps.setInt(1, clinicId);
            ps.executeUpdate();
        }
    }

    @Override
    public List<Clinic> getAllClinics() throws SQLException {
        List<Clinic> list = new ArrayList<>();
        try (Connection conn = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_ALL);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Clinic c = new Clinic();
                c.setClinicId(rs.getInt("clinic_id"));
                c.setClinicName(rs.getString("clinic_name"));
                c.setLocation(rs.getString("location"));
                c.setDoctorId(rs.getInt("doctor_id"));
                c.setContactNumber(rs.getString("contact_number"));
                c.setEstablishedYear(rs.getInt("established_year"));
                list.add(c);
            }
        }
        return list;
    }
}

