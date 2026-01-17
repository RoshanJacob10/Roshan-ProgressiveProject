package com.edutech.progressive.service.impl;

<<<<<<< HEAD
import com.edutech.progressive.entity.Doctor;
import com.edutech.progressive.service.DoctorService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DoctorServiceImplArraylist implements DoctorService {
    private static List<Doctor> doctorList = new ArrayList<>();

    @Override
    public List<Doctor> getAllDoctors() {
        return new ArrayList<>(doctorList);
    }

    @Override
    public Doctor getDoctorById(int doctorId) {
        return doctorList.stream().filter(d -> d.getDoctorId() == doctorId).findFirst().orElse(null);
    }

    @Override
    public Integer addDoctor(Doctor doctor) {
        doctorList.add(doctor);
        return doctor.getDoctorId();
    }

    @Override
    public List<Doctor> getDoctorSortedByExperience() {
        List<Doctor> copy = getAllDoctors();
        copy.sort(Comparator.naturalOrder());
        return copy;
    }

    @Override
    public void updateDoctor(Doctor doctor) {
        deleteDoctor(doctor.getDoctorId());
        doctorList.add(doctor);
    }

    @Override
    public void deleteDoctor(int doctorId) {
        doctorList.removeIf(d -> d.getDoctorId() == doctorId);
    }

    public void emptyArrayList() {
        doctorList.clear();
    }
}
=======
public class DoctorServiceImplArraylist  {

}
>>>>>>> 14b2fe69e8cff2c8d596699d41db370bea2e10f5
