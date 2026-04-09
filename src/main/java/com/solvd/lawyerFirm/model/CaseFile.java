package com.solvd.lawyerFirm.model;

import com.solvd.lawyerFirm.*;
import com.solvd.lawyerFirm.enums.CaseStatus;

import java.util.*;

public class CaseFile implements ICaseFile, Identifiable {

    private String title;
    private CaseStatus status;
    private Client client;
    private Lawyer lawyer;
    private Court court;
    private Judge judge;
    private int id;
    private static int counter = 0;

    private List<Witness> witnesses;
    private Set<Evidence> evidences;
    private Map<Integer, Document> documents;
    private Queue<Hearing> hearings;
    private Stack<Evidence> evidenceHistory;

    public CaseFile(Client client, Lawyer lawyer, Court court, Judge judge) {
        this.client = client;
        this.lawyer = lawyer;
        this.court = court;
        this.judge = judge;

        this.title = "Default Case";
        this.status = CaseStatus.OPEN;

        this.witnesses = new ArrayList<>();
        this.evidences = new HashSet<>();
        this.documents = new HashMap<>();
        this.hearings = new LinkedList<>();
        this.evidenceHistory = new Stack<>();

        this.id = counter++;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CaseStatus getStatus() {
        return status;
    }

    public void setStatus(CaseStatus status) {
        this.status = status;
    }

    @Override
    public void addHearing(Hearing hearing) {
        if (hearing == null) {
            throw new IllegalArgumentException("Hearing cannot be null");
        }
        hearings.add(hearing);
        updateStatus();
    }

    @Override
    public void addEvidence(Evidence evidence) {
        if (evidence == null) {
            throw new IllegalArgumentException("Evidence cannot be null");
        }
        if (status == CaseStatus.CLOSED) {
            throw new InvalidCaseStateException("Cannot add evidence to a closed case");
        }
        if (evidences.contains(evidence)) {
            throw new DuplicatedEvidenceException("Evidence already exists");
        }
        evidences.add(evidence);
        evidenceHistory.push(evidence);
        updateStatus();
    }

    @Override
    public void addDocument(Document document) {
        if (document == null) {
            throw new IllegalArgumentException("Document cannot be null");
        }
        documents.put(documents.size() + 1, document);
    }

    @Override
    public void addWitness(Witness witness) {
        if (witness == null) {
            throw new IllegalArgumentException("Witness cannot be null");
        }
        witnesses.add(witness);
    }

    @Override
    public void updateStatus() {
        if (!hearings.isEmpty()) {
            status = CaseStatus.IN_PROGRESS;
        }
        if (evidences.size() > 5) {
            status = CaseStatus.UNDER_REVIEW;
        }
        if (hearings.isEmpty() && evidences.isEmpty()) {
            status = CaseStatus.OPEN;
        }
    }

    @Override
    public String toString() {
        return "CaseFile{" +
                "\n title='" + title + '\'' +
                ",\n status=" + status +
                ",\n client=" + client +
                ",\n lawyer=" + lawyer +
                ",\n court=" + court +
                ",\n judge=" + judge +
                ",\n witnesses=" + witnesses +
                ",\n evidences=" + evidences +
                ",\n documents=" + documents +
                ",\n hearings=" + hearings +
                ",\n evidenceHistory=" + evidenceHistory +
                "\n}";
    }

    public Set<Evidence> getEvidences() {
        return evidences;
    }

    public Map<Integer, Document> getDocuments() {
        return documents;
    }

    public Queue<Hearing> getHearings() {
        return hearings;
    }

    public List<Witness> getWitnesses() {
        return witnesses;
    }

    public Stack<Evidence> getEvidenceHistory() {
        return evidenceHistory;
    }

    @Override
    public int getId() {
        return id;
    }
}