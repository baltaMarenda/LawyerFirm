package com.solvd.lawyerFirm.model;

public abstract class Person implements IHasRole {

    private String name;
    private int age;

    public Person(String name, int age) {
        if (name == null || name.isEmpty()) {
            throw new InvalidPersonException("Name cannot be null");
        }
        if (age < 0) {
            throw new InvalidPersonException("Age cannot be negative");
        }
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public abstract String setRole();

    @Override
    public abstract String getRole();

}