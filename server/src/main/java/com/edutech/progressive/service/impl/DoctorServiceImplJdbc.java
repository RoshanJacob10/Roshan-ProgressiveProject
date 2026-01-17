package com.edutech.progressive.service.impl;

import com.edutech.progressive.dao.DoctorDAO;
import com.edutech.progressive.entity.Doctor;
import com.edutech.progressive.service.DoctorService;

import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DoctorServiceImplJdbc implements DoctorService {
    private final DoctorDAO doctorDAO;

    public DoctorServiceImplJdbc(DoctorDAO doctorDAO) {
        this.doctorDAO = doctorDAO;
    }

    @Override
    public List<Doctor> getAllDoctors() {
        try {
            return doctorDAO.getAllDoctors();
        } catch (SQLException e) {
            return Collections.emptyList();
        }
    }

    @Override
    public Doctor getDoctorById(int doctorId) {
        try {
            return doctorDAO.getDoctorById(doctorId);
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public Integer addDoctor(Doctor doctor) {
        try {
            return doctorDAO.addDoctor(doctor);
        } catch (SQLException e) {
            return -1;
        }
    }

    @Override
    public List<Doctor> getDoctorSortedByExperience() {
        List<Doctor> list = getAllDoctors();
        list.sort(Comparator.comparingInt(Doctor::getYearsOfExperience).reversed());
        return list;
    }

    @Override
    public void updateDoctor(Doctor doctor) {
        try {
            doctorDAO.updateDoctor(doctor);
        } catch (SQLException e) {
        }
    }

    @Override
    public void deleteDoctor(int doctorId) {
        try {
            doctorDAO.deleteDoctor(doctorId);
        } catch (SQLException e) {
        }
    }
}
