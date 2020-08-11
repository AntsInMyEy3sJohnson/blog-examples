package com.nicokrieg.blog.examples.orthogonality.tightcoupling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Customer {

    private final long id;
    private final String name;
    private final List<Invoice> invoices;

    public Customer(long id, String name) {
        this.id = id;
        this.name = name;
        this.invoices = new ArrayList<>();
    }

    public void initInvoices() {

        InvoiceReader invoiceReader = new InvoiceReader(String.format("invoices/%d.csv", id));
        try {
            BufferedReader bufferedReader = invoiceReader.getReader();
            bufferedReader.lines().forEach(line -> {
                String[] elements = line.split(",");
                String date = elements[0];
                String subject = elements[1];
                double amount = Double.parseDouble(elements[2]);
                invoices.add(new Invoice(date, subject, amount));
            });

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    // Getters truncated

}
