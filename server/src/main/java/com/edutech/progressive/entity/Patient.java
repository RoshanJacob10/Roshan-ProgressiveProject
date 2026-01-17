package com.edutech.progressive.entity;

<<<<<<< HEAD
import java.util.Date;

public class Patient implements Comparable<Patient> {
    private int PatientId;
    private String FullName;
    private Date DateOfBirth;
    private String ContactNumber;
    private String Email;
    private String Address;

    public Patient() {
    }

    public Patient(int patientId, String fullName, Date dateOfBirth, String contactNumber, String email,
            String address) {
        this.PatientId = patientId;
        this.FullName = fullName;
        this.DateOfBirth = dateOfBirth;
        this.ContactNumber = contactNumber;
        this.Email = email;
        this.Address = address;
    }

    public int getPatientId() {
        return PatientId;
    }

    public void setPatientId(int patientId) {
        PatientId = patientId;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(String contactNumber) {
        ContactNumber = contactNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    @Override
    public int compareTo(Patient o) {
        String a = this.FullName == null ? "" : this.FullName;
        String b = o == null || o.FullName == null ? "" : o.FullName;
        int r = String.CASE_INSENSITIVE_ORDER.compare(a, b);
        if (r != 0)
            return r;
        return Integer.compare(this.PatientId, o == null ? Integer.MAX_VALUE : o.PatientId);
    }
}
=======
public class Patient {

}
>>>>>>> 14b2fe69e8cff2c8d596699d41db370bea2e10f5
