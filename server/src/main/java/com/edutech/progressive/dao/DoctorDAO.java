package com.edutech.progressive.dao;

import com.edutech.progressive.entity.Doctor;
<<<<<<< HEAD
import java.sql.SQLException;
import java.util.List;

public interface DoctorDAO {
    int addDoctor(Doctor doctor) throws SQLException;

    Doctor getDoctorById(int doctorId) throws SQLException;

    void updateDoctor(Doctor doctor) throws SQLException;

    void deleteDoctor(int doctorId) throws SQLException;

    List<Doctor> getAllDoctors() throws SQLException;
=======

import java.util.List;

public interface DoctorDAO {
    int addDoctor(Doctor doctor);
    Doctor getDoctorById(int doctorId);
    void updateDoctor(Doctor doctor);
    void deleteDoctor(int doctorId) ;
    List<Doctor> getAllDoctors();
>>>>>>> 14b2fe69e8cff2c8d596699d41db370bea2e10f5
}
