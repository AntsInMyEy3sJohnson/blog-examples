package io.github.antsinmyey3sjohnson.orthogonality.inappropriateintimacy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class InvoiceReader3 {

    private final String filePath;

    public InvoiceReader3(String filePath) {
        this.filePath = filePath;
    }

    public List<String> parseDates() {

        try {
            return getReader().lines().map(line -> line.split(",")[0]).collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            // Exception handling
        }

        return Collections.emptyList();

    }

    public List<String> parseSubjects() {

        try {
            return getReader().lines().map(line -> line.split(",")[1]).collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            // Exception handling
        }

        return Collections.emptyList();

    }

    public List<Double> parseAmounts() {

        try {
            return getReader().lines().map(line -> Double.parseDouble(line.split(",")[2])).collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            // Exception handling
        }

        return Collections.emptyList();

    }

    private BufferedReader getReader() throws FileNotFoundException {

        return new BufferedReader(new FileReader(filePath));

    }


}
