package com.edutech.progressive.dao;

<<<<<<< HEAD
import com.edutech.progressive.config.DatabaseConnectionManager;
import com.edutech.progressive.entity.Doctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAOImpl implements DoctorDAO {
    private static final String INSERT_SQL = "INSERT INTO doctor (full_name, specialty, contact_number, email, years_of_experience) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_BY_ID = "SELECT doctor_id, full_name, specialty, contact_number, email, years_of_experience FROM doctor WHERE doctor_id = ?";
    private static final String UPDATE_SQL = "UPDATE doctor SET full_name = ?, specialty = ?, contact_number = ?, email = ?, years_of_experience = ? WHERE doctor_id = ?";
    private static final String DELETE_SQL = "DELETE FROM doctor WHERE doctor_id = ?";
    private static final String SELECT_ALL = "SELECT doctor_id, full_name, specialty, contact_number, email, years_of_experience FROM doctor";

    @Override
    public int addDoctor(Doctor doctor) throws SQLException {
        try (Connection conn = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, doctor.getFullName());
            ps.setString(2, doctor.getSpecialty());
            ps.setString(3, doctor.getContactNumber());
            ps.setString(4, doctor.getEmail());
            ps.setInt(5, doctor.getYearsOfExperience());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) return rs.getInt(1);
            }
        }
        return -1;
    }

    @Override
    public Doctor getDoctorById(int doctorId) throws SQLException {
        try (Connection conn = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID)) {
            ps.setInt(1, doctorId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Doctor d = new Doctor();
                    d.setDoctorId(rs.getInt("doctor_id"));
                    d.setFullName(rs.getString("full_name"));
                    d.setSpecialty(rs.getString("specialty"));
                    d.setContactNumber(rs.getString("contact_number"));
                    d.setEmail(rs.getString("email"));
                    d.setYearsOfExperience(rs.getInt("years_of_experience"));
                    return d;
                }
            }
        }
        return null;
    }

    @Override
    public void updateDoctor(Doctor doctor) throws SQLException {
        try (Connection conn = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            ps.setString(1, doctor.getFullName());
            ps.setString(2, doctor.getSpecialty());
            ps.setString(3, doctor.getContactNumber());
            ps.setString(4, doctor.getEmail());
            ps.setInt(5, doctor.getYearsOfExperience());
            ps.setInt(6, doctor.getDoctorId());
            ps.executeUpdate();
        }
    }

    @Override
    public void deleteDoctor(int doctorId) throws SQLException {
        try (Connection conn = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(DELETE_SQL)) {
            ps.setInt(1, doctorId);
            ps.executeUpdate();
        }
    }

    @Override
    public List<Doctor> getAllDoctors() throws SQLException {
        List<Doctor> list = new ArrayList<>();
        try (Connection conn = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_ALL);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Doctor d = new Doctor();
                d.setDoctorId(rs.getInt("doctor_id"));
                d.setFullName(rs.getString("full_name"));
                d.setSpecialty(rs.getString("specialty"));
                d.setContactNumber(rs.getString("contact_number"));
                d.setEmail(rs.getString("email"));
                d.setYearsOfExperience(rs.getInt("years_of_experience"));
                list.add(d);
            }
        }
        return list;
    }
}

=======

public class DoctorDAOImpl {



}
>>>>>>> 14b2fe69e8cff2c8d596699d41db370bea2e10f5
