package io.github.antsinmyey3sjohnson.orthogonality.tightcoupling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class InvoiceReader1 {

    private final String filePath;

    public InvoiceReader1(String filePath) {
        this.filePath = filePath;
    }

    public BufferedReader getReader() throws FileNotFoundException {

        return new BufferedReader(new FileReader(filePath));

    }
}
