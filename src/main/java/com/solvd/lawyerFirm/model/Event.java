package com.solvd.lawyerFirm.model;

import java.util.Date;

public abstract class Event {
    private Date date;

    public Event(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
