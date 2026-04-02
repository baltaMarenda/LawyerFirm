package com.solvd.lawyerFirm.model;

public class Lawyer extends LegalProfessional {

    private String specialization;

    public Lawyer(String name, String specialization, int age) {
        super(name, age);
        this.specialization = specialization;
    }

    @Override
    public String setRole() {
        return "Lawyer";
    }

    @Override
    public String getRole() {
        return "Lawyer";
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "Lawyer{" +
                "specialization='" + specialization + '\'' +
                '}';
    }
}