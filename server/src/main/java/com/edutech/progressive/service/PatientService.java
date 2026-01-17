package com.edutech.progressive.service;

<<<<<<< HEAD
import com.edutech.progressive.entity.Patient;
import java.util.List;

public interface PatientService {
=======
import com.edutech.progressive.dto.PatientDTO;
import com.edutech.progressive.entity.Patient;

import java.util.List;

public interface PatientService {

>>>>>>> 14b2fe69e8cff2c8d596699d41db370bea2e10f5
    List<Patient> getAllPatients();

    Integer addPatient(Patient patient);

    List<Patient> getAllPatientSortedByName();

<<<<<<< HEAD
    void updatePatient(Patient patient);

    void deletePatient(int patientId);

    Patient getPatientById(int patientId);

    void emptyArrayList();
=======
    default void emptyArrayList() {
    }

    //Do not implement these methods in PatientServiceImplArraylist.java class
    default void updatePatient(Patient patient) {}

    default void deletePatient(int patientId) {}

    default Patient getPatientById(int patientId) {
        return null;
    }

    //Do not implement these methods in PatientServiceImplArraylist.java and PatientServiceImplJdbc.java class
    //Do not implement this method until day-13
    default public void modifyPatientDetails(PatientDTO patientDTO) { }
>>>>>>> 14b2fe69e8cff2c8d596699d41db370bea2e10f5
}
