package com.solvd.lawyerFirm.model;

import java.util.Objects;

public class Client extends Person {

    private String problem;

    public Client(String name, String problem, int age) {
        super(name, age);
        this.problem = problem;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
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
                ", problem='" + problem + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return Objects.equals(getName(), client.getName()) &&
                Objects.equals(problem, client.problem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), problem);
    }
}