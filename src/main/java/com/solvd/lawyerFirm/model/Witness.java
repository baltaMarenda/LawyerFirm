package com.solvd.lawyerFirm.model;

public class Witness extends Person {

    public Witness(String name, int age) {
        super(name, age);
    }

    @Override
    public String setRole() {
        return "Witness";
    }

    @Override
    public String getRole() {
        return "Witness";
    }

    @Override
    public String toString() {
        return "Witness{" +
                "name='" + getName() + '\'' +
                '}';
    }
}