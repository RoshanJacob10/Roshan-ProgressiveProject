package com.edutech.progressive.service.impl;

<<<<<<< HEAD
import com.edutech.progressive.dao.ClinicDAO;
import com.edutech.progressive.entity.Clinic;
import com.edutech.progressive.service.ClinicService;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class ClinicServiceImplJdbc implements ClinicService {
    private final ClinicDAO clinicDAO;

    public ClinicServiceImplJdbc(ClinicDAO clinicDAO) {
        this.clinicDAO = clinicDAO;
    }

    @Override
    public List<Clinic> getAllClinics() {
        try {
            return clinicDAO.getAllClinics();
        } catch (SQLException e) {
            return Collections.emptyList();
        }
    }

    @Override
    public Clinic getClinicById(int clinicId) {
        try {
            return clinicDAO.getClinicById(clinicId);
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public Integer addClinic(Clinic clinic) {
        try {
            return clinicDAO.addClinic(clinic);
        } catch (SQLException e) {
            return -1;
        }
    }

    @Override
    public void updateClinic(Clinic clinic) {
        try {
            clinicDAO.updateClinic(clinic);
        } catch (SQLException e) {
        }
    }

    @Override
    public void deleteClinic(int clinicId) {
        try {
            clinicDAO.deleteClinic(clinicId);
        } catch (SQLException e) {
        }
    }
}
=======
public class ClinicServiceImplJdbc  {

}
>>>>>>> 14b2fe69e8cff2c8d596699d41db370bea2e10f5
