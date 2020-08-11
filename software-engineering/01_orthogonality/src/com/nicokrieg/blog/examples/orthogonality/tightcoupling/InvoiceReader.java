package com.nicokrieg.blog.examples.orthogonality.tightcoupling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class InvoiceReader {

    private final String filePath;

    public InvoiceReader(String filePath) {
        this.filePath = filePath;
    }

    public BufferedReader getReader() throws FileNotFoundException {

        return new BufferedReader(new FileReader(filePath));

    }
}
