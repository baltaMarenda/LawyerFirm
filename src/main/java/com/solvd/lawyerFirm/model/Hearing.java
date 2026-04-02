package com.solvd.lawyerFirm.model;

import java.util.Objects;
import java.util.Set;

public class Hearing implements Schedulable {

    private String date;

    public Hearing(String date) {
        this.date = date;
    }

    @Override
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Hearing{" +
                "date='" + date + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hearing)) return false;
        Hearing hearing = (Hearing) o;
        return Objects.equals(date, hearing.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date);
    }
}