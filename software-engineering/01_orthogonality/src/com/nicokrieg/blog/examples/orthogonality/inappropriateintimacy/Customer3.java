package com.nicokrieg.blog.examples.orthogonality.inappropriateintimacy;


import com.nicokrieg.blog.examples.orthogonality.Invoice;

import java.util.ArrayList;
import java.util.List;

public class Customer3 {

    private final long id;
    private final String name;
    private final List<Invoice> invoices;

    public Customer3(long id, String name) {
        this.id = id;
        this.name = name;
        this.invoices = new ArrayList<>();
        initInvoices();
    }

    public void initInvoices() {

        var invoiceReader = new InvoiceReader3("invoices/%d.csv".formatted(id));
        List<String> dates = invoiceReader.parseDates();
        List<String> subjects = invoiceReader.parseSubjects();
        List<Double> amounts = invoiceReader.parseAmounts();
        for (int i = 0; i < dates.size(); i++) {
            invoices.add(new Invoice(dates.get(i), subjects.get(i), amounts.get(i)));
        }

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Customer '%s' with ID '%d' has %d %s.".formatted(name, id, invoices.size(), invoices.size() == 1 ? "invoice" : "invoices");
    }

}
