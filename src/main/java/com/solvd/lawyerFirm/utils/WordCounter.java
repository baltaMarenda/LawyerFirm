package com.solvd.lawyerFirm.utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class WordCounter {

    public static void countWords(File input, File output) {

        try {
            String content = FileUtils.readFileToString(input, StandardCharsets.UTF_8);

            int theCount = StringUtils.countMatches(content.toLowerCase(), "the");
            int andCount = StringUtils.countMatches(content.toLowerCase(), "and");
            int lawCount = StringUtils.countMatches(content.toLowerCase(), "law");

            String result = "\n--- New Analysis ---\n" +
                    "the: " + theCount + "\n" +
                    "and: " + andCount + "\n" +
                    "law: " + lawCount + "\n";

            FileUtils.writeStringToFile(output, result, StandardCharsets.UTF_8, true);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}