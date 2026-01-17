package com.edutech.progressive.service;

import com.edutech.progressive.entity.Clinic;
<<<<<<< HEAD
import java.util.List;

public interface ClinicService {
    List<Clinic> getAllClinics();

    Clinic getClinicById(int clinicId);

    Integer addClinic(Clinic clinic);

    void updateClinic(Clinic clinic);

    void deleteClinic(int clinicId);
=======

import java.util.List;

public interface ClinicService {

    public List<Clinic> getAllClinics();

    public Clinic getClinicById(int clinicId);

    public Integer addClinic(Clinic clinic);

    public void updateClinic(Clinic clinic);

    public void deleteClinic(int clinicId);

    //Do not implement these methods in ClinicServiceImplJdbc.java class
    default public List<Clinic> getAllClinicByLocation(String location) { return null; }

    default public List<Clinic> getAllClinicByDoctorId(int doctorId) { return null; }
>>>>>>> 14b2fe69e8cff2c8d596699d41db370bea2e10f5
}
