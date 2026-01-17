package com.edutech.progressive.dao;

import com.edutech.progressive.entity.Clinic;
<<<<<<< HEAD
import java.sql.SQLException;
import java.util.List;

public interface ClinicDAO {
    int addClinic(Clinic clinic) throws SQLException;

    Clinic getClinicById(int clinicId) throws SQLException;

    void updateClinic(Clinic clinic) throws SQLException;

    void deleteClinic(int clinicId) throws SQLException;

    List<Clinic> getAllClinics() throws SQLException;
}
=======

import java.util.List;

public interface ClinicDAO {
    int addClinic(Clinic clinic);
    Clinic getClinicById(int clinicId);
    void updateClinic(Clinic clinic);
    void deleteClinic(int clinicId);
    List<Clinic> getAllClinics();
}
>>>>>>> 14b2fe69e8cff2c8d596699d41db370bea2e10f5
