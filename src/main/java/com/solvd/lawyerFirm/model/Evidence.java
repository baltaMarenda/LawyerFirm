package com.solvd.lawyerFirm.model;

import java.util.Objects;

public class Evidence {

    private String description;

    public Evidence(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Evidence{" +
                "description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Evidence)) return false;
        Evidence evidence = (Evidence) o;
        return Objects.equals(description, evidence.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description);
    }
}