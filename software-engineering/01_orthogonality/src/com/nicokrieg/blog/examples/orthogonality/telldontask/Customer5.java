package com.nicokrieg.blog.examples.orthogonality.telldontask;

import com.nicokrieg.blog.examples.orthogonality.Invoice;
import com.nicokrieg.blog.examples.orthogonality.lowcouplinghighcohesion.InvoiceReader2;

import java.util.List;

public class Customer5 {

    private final long id;
    private final String name;
    private final Account2 account2;
    private final List<Invoice> invoices;

    public Customer5(long id, String name, Account2 account2) {
        this.id = id;
        this.name = name;
        this.account2 = account2;
        this.invoices = InvoiceReader2.getInstance().getInvoicesByCustomerID(id);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void payInvoices() {

        invoices.removeIf(invoice -> account2.deduct(invoice.getAmount()));
        printInvoicesSummary();

    }

    @Override
    public String toString() {
        return "Customer '%s' with ID '%d' has %d %s.".formatted(name, id, invoices.size(), invoices.size() == 1 ? "invoice" : "invoices");
    }

    private void printInvoicesSummary() {

        if (invoices.isEmpty()) {
            System.out.println("All invoices paid, current account balance: %.2f".formatted(account2.getBalance()));
        } else {
            System.out.println("Unable to pay the following invoices: ");
            invoices.forEach(System.out::println);
            System.out.println("Account balance left: %.2f".formatted(account2.getBalance()));
        }

    }

}
