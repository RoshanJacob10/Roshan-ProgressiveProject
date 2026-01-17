package com.edutech.progressive.entity;

public class Doctor implements Comparable<Doctor> {
    private int DoctorId;
    private String FullName;
    private String Specialty;
    private String ContactNumber;
    private String Email;
    private int YearsOfExperience;

    public Doctor() {
    }

    public Doctor(int doctorId, String fullName, String specialty, String contactNumber, String email,
            int yearsOfExperience) {
        this.DoctorId = doctorId;
        this.FullName = fullName;
        this.Specialty = specialty;
        this.ContactNumber = contactNumber;
        this.Email = email;
        this.YearsOfExperience = yearsOfExperience;
    }

    public int getDoctorId() {
        return DoctorId;
    }

    public void setDoctorId(int doctorId) {
        DoctorId = doctorId;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getSpecialty() {
        return Specialty;
    }

    public void setSpecialty(String specialty) {
        Specialty = specialty;
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

    public int getYearsOfExperience() {
        return YearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        YearsOfExperience = yearsOfExperience;
    }

    @Override
    public int compareTo(Doctor o) {
        int r = Integer.compare(this.YearsOfExperience, o == null ? Integer.MAX_VALUE : o.YearsOfExperience);
        if (r != 0)
            return r;
        String a = this.FullName == null ? "" : this.FullName;
        String b = o == null || o.FullName == null ? "" : o.FullName;
        r = String.CASE_INSENSITIVE_ORDER.compare(a, b);
        if (r != 0)
            return r;
        return Integer.compare(this.DoctorId, o == null ? Integer.MAX_VALUE : o.DoctorId);
    }
}
