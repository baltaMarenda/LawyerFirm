package com.solvd.lawyerFirm.model;

import java.util.Objects;
import com.solvd.lawyerFirm.enums.DocumentType;

public class Document implements Describable {

    private String title;
    private DocumentType documentType;

    public Document(String title, DocumentType documentType) {
        this.title = title;
        this.documentType = documentType;
    }

    public String getTitle() {
        return title;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    @Override
    public String getDescription() {
        return title + " (" + documentType + ")";
    }

    @Override
    public String toString() {
        return "Document{" +
                "title='" + title + '\'' +
                ", documentType=" + documentType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Document)) return false;
        Document document = (Document) o;
        return Objects.equals(title, document.title) &&
                documentType == document.documentType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, documentType);
    }
}