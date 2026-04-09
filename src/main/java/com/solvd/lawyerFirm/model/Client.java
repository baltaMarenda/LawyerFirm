package com.solvd.lawyerFirm.model;

import java.util.Objects;
import com.solvd.lawyerFirm.enums.CrimeType;

public class Client extends Person {

    private CrimeType crimeType;

    public Client(String name, CrimeType crimeType, int age) {
        super(name, age);
        this.crimeType = crimeType;
    }

    public CrimeType getCrimeType() {
        return crimeType;
    }

    public void setCrimeType(CrimeType crimeType) {
        this.crimeType = crimeType;
    }

    @Override
    public String setRole() {
        return "Client";
    }

    @Override
    public String getRole() {
        return "Client";
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + getName() + '\'' +
                ", crimeType=" + crimeType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return Objects.equals(getName(), client.getName()) &&
                crimeType == client.crimeType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), crimeType);
    }
}