package io.github.antsinmyey3sjohnson.orthogonality.lowcouplinghighcohesion;

import io.github.antsinmyey3sjohnson.orthogonality.Invoice;

import java.util.List;

public class Customer2 {

    private final long id;
    private final String name;
    private final List<Invoice> invoices;

    public Customer2(long id, String name) {
        this.id = id;
        this.name = name;
        this.invoices = InvoiceReader2.getInstance().getInvoicesByCustomerID(id);
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
