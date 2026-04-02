package com.solvd.lawyerFirm.model;

public class Judge extends LegalProfessional {

    public Judge(String name, int age) {
        super(name, age);
    }

    @Override
    public String setRole() {
        return "Judge";
    }

    @Override
    public String getRole() {
        return "Judge";
    }

    @Override
    public String toString() {
        return "Judge{" +
                "name='" + getName() + '\'' +
                '}';
    }
}