package com.solvd.lawyerFirm;

import com.solvd.lawyerFirm.utils.WordCounter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class Test {

    private static final Logger logger = LogManager.getLogger(Test.class);

    public static void main(String[] args) {

        logger.info("=== WORD COUNTER TEST START ===");

        try {
            File input = new File("input.txt");
            File output = new File("output.txt");

            WordCounter.countWords(input, output);

            logger.info("Word count executed successfully. Check output.txt");

        } catch (Exception e) {
            logger.error("Error during test: " + e.getMessage());
        }

        logger.info("=== WORD COUNTER TEST END ===");
    }
}
