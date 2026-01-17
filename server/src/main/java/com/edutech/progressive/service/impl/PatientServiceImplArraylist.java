package com.edutech.progressive.service.impl;

import com.edutech.progressive.entity.Patient;
import com.edutech.progressive.service.PatientService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PatientServiceImplArraylist implements PatientService {
    private static List<Patient> patientList = new ArrayList<>();

    @Override
    public List<Patient> getAllPatients() {
        return new ArrayList<>(patientList);
    }

    @Override
    public Integer addPatient(Patient patient) {
        patientList.add(patient);
        return patient.getPatientId();
    }

    @Override
    public List<Patient> getAllPatientSortedByName() {
        List<Patient> copy = getAllPatients();
        copy.sort(Comparator.naturalOrder());
        return copy;
    }

    @Override
    public void updatePatient(Patient patient) {
        deletePatient(patient.getPatientId());
        patientList.add(patient);
    }

    @Override
    public void deletePatient(int patientId) {
        patientList.removeIf(p -> p.getPatientId() == patientId);
    }

    @Override
    public Patient getPatientById(int patientId) {
        return patientList.stream().filter(p -> p.getPatientId() == patientId).findFirst().orElse(null);
    }

    @Override
    public void emptyArrayList() {
        patientList.clear();
    }
}
