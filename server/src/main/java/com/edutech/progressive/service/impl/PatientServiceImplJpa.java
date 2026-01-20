package com.edutech.progressive.service.impl;

import com.edutech.progressive.entity.Patient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientServiceImplJpa {

    public List<Patient> getAllPatients() throws Exception {
        return new ArrayList<>();
    }

    public Patient getPatientById(int patientId) throws Exception {
        return null;
    }

    public Integer addPatient(Patient patient) throws Exception {
        return -1;
    }

    public void updatePatient(Patient patient) throws Exception {
    }

    public void deletePatient(int patientId) throws Exception {
    }
}
