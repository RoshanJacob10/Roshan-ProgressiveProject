package com.edutech.progressive.service;

import com.edutech.progressive.entity.Doctor;
import java.util.List;

public interface DoctorService {
    List<Doctor> getAllDoctors();

    Doctor getDoctorById(int doctorId);

    Integer addDoctor(Doctor doctor);

    List<Doctor> getDoctorSortedByExperience();

    void updateDoctor(Doctor doctor);

    void deleteDoctor(int doctorId);
}
