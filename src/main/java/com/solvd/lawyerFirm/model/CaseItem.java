package com.solvd.lawyerFirm.model;

public abstract class CaseItem {
    private String description;

    public CaseItem(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
