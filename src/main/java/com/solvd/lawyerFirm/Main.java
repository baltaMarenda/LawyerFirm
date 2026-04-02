package com.solvd.lawyerFirm;

import com.solvd.lawyerFirm.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        logger.info("=== SYSTEM START ===");

        try {
            Client client = new Client("Juan Perez", "Robbery", 30);
            Lawyer lawyer = new Lawyer("Dr. Gomez", "Criminal Law", 45);
            Judge judge = new Judge("Judge Ramirez", 60);

            Witness witness1 = new Witness("Carlos Lopez", 35);
            Witness witness2 = new Witness("Ana Torres", 28);

            logger.info("People created successfully");

            List<Person> people = new ArrayList<>();
            people.add(client);
            people.add(lawyer);
            people.add(judge);
            people.add(witness1);
            people.add(witness2);

            for (Person p : people) {
                logger.info(p.getName() + " is a " + p.getRole());
            }

            Court court = new Court("Supreme Court");
            CaseFile caseFile = new CaseFile(client, lawyer, court, judge);

            logger.info("CaseFile created with ID: " + caseFile.getId());

            Evidence e1 = new Evidence("Fingerprint");
            Evidence e2 = new Evidence("Camera footage");

            caseFile.addEvidence(e1);
            caseFile.addEvidence(e2);

            logger.info("Evidence added");

            try {
                caseFile.addEvidence(new Evidence("Fingerprint"));
            } catch (DuplicatedEvidenceException e) {
                logger.error("Expected error: " + e.getMessage());
            }

            Document d1 = new Document("Police Report");
            Document d2 = new Document("Contract");

            caseFile.addDocument(d1);
            caseFile.addDocument(d2);

            logger.info("Documents added");

            Hearing h1 = new Hearing("2026-03-20");
            Hearing h2 = new Hearing("2026-04-10");

            caseFile.addHearing(h1);
            caseFile.addHearing(h2);

            logger.info("Hearings added");

            caseFile.addWitness(witness1);
            caseFile.addWitness(witness2);

            logger.info("Witnesses added");

            Client client2 = new Client("Juan Perez", "Robbery", 30);
            logger.info("Clients equal: " + client.equals(client2));

            caseFile.setStatus("CLOSED");
            logger.warn("Case closed");

            try {
                caseFile.addEvidence(new Evidence("New Evidence"));
            } catch (InvalidCaseStateException e) {
                logger.error("Expected error: " + e.getMessage());
            }

            try {
                Client invalid = new Client("", "Fraud", -1);
            } catch (InvalidPersonException e) {
                logger.error("Expected error: " + e.getMessage());
            }



            Repository<Evidence> evidenceRepository = new Repository<>();
            evidenceRepository.add(e1);
            evidenceRepository.add(e2);

            logger.info("Repository size: " + evidenceRepository.getAll().size());


            Pair<String, Client> caseOwner = new Pair<>("CaseOwner", client);
            logger.info("Pair -> " + caseOwner.getFirst() + ": " + caseOwner.getSecond().getName());


            Validator<Client> clientValidator = new Validator<>();
            boolean isValid = clientValidator.isValid(client);
            logger.info("Client valid: " + isValid);



            logger.info("=== SUMMARY ===");
            logger.info("Status: " + caseFile.getStatus());
            logger.info("Evidence count: " + caseFile.getEvidences().size());
            logger.info("Document count: " + caseFile.getDocuments().size());
            logger.info("Hearing count: " + caseFile.getHearings().size());
            logger.info("Witness count: " + caseFile.getWitnesses().size());

            logger.info("=== EVIDENCE LIST ===");
            for (Evidence ev : caseFile.getEvidences()) {
                logger.info(ev.getDescription());
            }

            logger.info("=== DOCUMENT LIST ===");
            for (Document doc : caseFile.getDocuments().values()) {
                logger.info(doc.getTitle());
            }

            logger.info("=== HEARING LIST ===");
            for (Hearing h : caseFile.getHearings()) {
                logger.info(h.getDate());
            }

        } catch (Exception e) {
            logger.fatal("Unexpected error: " + e.getMessage());
        }

        logger.info("=== SYSTEM END ===");
    }
}