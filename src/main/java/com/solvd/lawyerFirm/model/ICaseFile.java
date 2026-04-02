package com.solvd.lawyerFirm.model;

public interface ICaseFile {
    void addHearing(Hearing hearing);

    void addEvidence(Evidence evidence);

    void addDocument(Document document);

    void addWitness(Witness witness);

    void updateStatus();

}
