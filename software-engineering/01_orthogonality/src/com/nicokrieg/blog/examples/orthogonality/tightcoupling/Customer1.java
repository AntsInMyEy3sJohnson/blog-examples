package com.nicokrieg.blog.examples.orthogonality.tightcoupling;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Customer1 {

    private final long id;
    private final String name;
    private final List<Invoice> invoices;

    public Customer1(long id, String name) {
        this.id = id;
        this.name = name;
        this.invoices = new ArrayList<>();
        initInvoices();
    }

    public void initInvoices() {

        var invoiceReader = new InvoiceReader1("invoices/%d.csv".formatted(id));
        try {
            var bufferedReader = invoiceReader.getReader();
            bufferedReader.lines().forEach(line -> {
                var invoiceElements = line.split(",");
                var date = invoiceElements[0];
                var subject = invoiceElements[1];
                var amount = Double.parseDouble(invoiceElements[2]);
                invoices.add(new Invoice(date, subject, amount));
            });
        } catch (FileNotFoundException e) {
            // Exception handling
        }

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    @Override
    public String toString() {
        return "Customer '%s' with ID '%d' has %d invoices.".formatted(name, id, invoices.size());
    }

}
