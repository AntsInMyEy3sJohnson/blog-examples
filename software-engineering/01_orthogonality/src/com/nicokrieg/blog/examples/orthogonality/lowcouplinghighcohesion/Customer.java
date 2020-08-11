package com.nicokrieg.blog.examples.orthogonality.lowcouplinghighcohesion;

import java.util.List;

public class Customer {

    private final long id;
    private final String name;
    private final List<Invoice> invoices;

    public Customer(long id, String name) {
        this.id = id;
        this.name = name;
        this.invoices = InvoiceReader.getInstance().getInvoicesByCustomerID(id);
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

}
