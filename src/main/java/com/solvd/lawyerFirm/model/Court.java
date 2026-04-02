package com.solvd.lawyerFirm.model;

public class Court {

    private String courtName;

    public Court(String courtName) {
        this.courtName = courtName;
    }

    public String getCourtName() {
        return courtName;
    }

    public void setCourtName(String courtName) {
        this.courtName = courtName;
    }

    @Override
    public String toString() {
        return "Court{" +
                "courtName='" + courtName + '\'' +
                '}';
    }
}