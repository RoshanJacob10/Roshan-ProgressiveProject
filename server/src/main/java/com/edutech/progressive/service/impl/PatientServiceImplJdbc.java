package com.edutech.progressive.service.impl;

<<<<<<< HEAD
import com.edutech.progressive.dao.PatientDAO;
import com.edutech.progressive.entity.Patient;
import com.edutech.progressive.service.PatientService;

import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PatientServiceImplJdbc implements PatientService {
    private final PatientDAO patientDAO;

    public PatientServiceImplJdbc(PatientDAO patientDAO) {
        this.patientDAO = patientDAO;
    }

    @Override
    public List<Patient> getAllPatients() {
        try {
            return patientDAO.getAllPatients();
        } catch (SQLException e) {
            return Collections.emptyList();
        }
    }

    @Override
    public Integer addPatient(Patient patient) {
        try {
            return patientDAO.addPatient(patient);
        } catch (SQLException e) {
            return -1;
        }
    }

    @Override
    public List<Patient> getAllPatientSortedByName() {
        List<Patient> list = getAllPatients();
        list.sort(Comparator.comparing(Patient::getFullName, String.CASE_INSENSITIVE_ORDER));
        return list;
    }

    @Override
    public void updatePatient(Patient patient) {
        try {
            patientDAO.updatePatient(patient);
        } catch (SQLException e) {
        }
    }

    @Override
    public void deletePatient(int patientId) {
        try {
            patientDAO.deletePatient(patientId);
        } catch (SQLException e) {
        }
    }

    @Override
    public Patient getPatientById(int patientId) {
        try {
            return patientDAO.getPatientById(patientId);
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public void emptyArrayList() {
    }
}
=======
public class PatientServiceImplJdbc  {

}
>>>>>>> 14b2fe69e8cff2c8d596699d41db370bea2e10f5
