package com.edutech.progressive.service.impl;

import com.edutech.progressive.entity.Patient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class PatientServiceImplArraylist {

    private static final List<Patient> patientList = new ArrayList<>();

    public List<Patient> getAllPatients() {
        return new ArrayList<>(patientList);
    }

    public Integer addPatient(Patient patient) {
        if (patient.getPatientId() == 0) {
            int nextId = patientList.size() + 1;
            patient.setPatientId(nextId);
        }
        patientList.add(patient);
        return patient.getPatientId();
    }

    public List<Patient> getAllPatientSortedByName() {
        List<Patient> copy = new ArrayList<>(patientList);
        copy.sort(Comparator.comparing(Patient::getFullName, String.CASE_INSENSITIVE_ORDER));
        return copy;
    }

    public void emptyArrayList() {
        patientList.clear();
    }
}
