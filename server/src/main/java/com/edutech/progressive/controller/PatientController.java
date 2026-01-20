package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Patient;
import com.edutech.progressive.service.impl.PatientServiceImplArraylist;
import com.edutech.progressive.service.impl.PatientServiceImplJpa;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private final PatientServiceImplJpa patientServiceJpa;
    private final PatientServiceImplArraylist patientServiceArrayList;

    public PatientController(PatientServiceImplJpa patientServiceJpa,
                             PatientServiceImplArraylist patientServiceArrayList) {
        this.patientServiceJpa = patientServiceJpa;
        this.patientServiceArrayList = patientServiceArrayList;
    }

    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        try {
            List<Patient> patients = patientServiceJpa.getAllPatients();
            return ResponseEntity.ok(patients);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{patientID}")
    public ResponseEntity<Patient> getPatientById(@PathVariable("patientID") int patientId) {
        try {
            Patient p = patientServiceJpa.getPatientById(patientId);
            return ResponseEntity.ok(p);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<Integer> addPatient(@RequestBody Patient patient) {
        try {
            Integer id = patientServiceJpa.addPatient(patient);
            return ResponseEntity.ok(id);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{patientID}")
    public ResponseEntity<Void> updatePatient(@PathVariable("patientID") int patientId,
                                              @RequestBody Patient patient) {
        try {
            patient.setPatientId(patientId);
            patientServiceJpa.updatePatient(patient);
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{patientID}")
    public ResponseEntity<Void> deletePatient(@PathVariable("patientID") int patientId) {
        try {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/fromArrayList")
    public ResponseEntity<List<Patient>> getAllPatientFromArrayList() {
        List<Patient> list = patientServiceArrayList.getAllPatients();
        return ResponseEntity.ok(list);
    }

    @PostMapping("/toArrayList")
    public ResponseEntity<Void> addPatientToArrayList(@RequestBody Patient patient) {
        patientServiceArrayList.addPatient(patient);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/fromArrayList/sorted")
    public ResponseEntity<List<Patient>> getAllPatientSortedByNameFromArrayList() {
        List<Patient> sorted = patientServiceArrayList.getAllPatientSortedByName();
        return ResponseEntity.ok(sorted);
    }
}

