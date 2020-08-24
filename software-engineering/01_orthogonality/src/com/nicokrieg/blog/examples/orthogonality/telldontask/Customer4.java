package com.nicokrieg.blog.examples.orthogonality.telldontask;

import com.nicokrieg.blog.examples.orthogonality.Invoice;
import com.nicokrieg.blog.examples.orthogonality.lowcouplinghighcohesion.InvoiceReader2;

import java.util.List;

public class Customer4 {

    private final long id;
    private final String name;
    private final Account1 account;
    private List<Invoice> invoices;

    public Customer4(long id, String name, Account1 account) {
        this.id = id;
        this.name = name;
        this.account = account;
        this.invoices = InvoiceReader2.getInstance().getInvoicesByCustomerID(id);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Account1 getAccount() {
        return account;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

}
