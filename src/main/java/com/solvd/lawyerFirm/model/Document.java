package com.solvd.lawyerFirm.model;

import java.util.Objects;

public class Document implements Describable {

    private String title;

    public Document(String title) {
        this.title = title;
    }

    @Override
    public String getDescription() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Document{" +
                "title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Document)) return false;
        Document document = (Document) o;
        return Objects.equals(title, document.title);
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}