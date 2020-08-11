package com.nicokrieg.blog.examples.orthogonality.lowcouplinghighcohesion;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class InvoiceReader {

    private static InvoiceReader invoiceReader;

    private InvoiceReader() {
    }

    public static InvoiceReader getInstance() {
        if (Objects.isNull(invoiceReader)) {
            invoiceReader = new InvoiceReader();
        }
        return invoiceReader;
    }

    public List<Invoice> getInvoicesByCustomerID(long customerID) {

        try {
            return Files.lines(Paths.get(String.format("invoices/%d.csv", customerID)))
                    .map(invoiceString -> {
                        String[] invoiceData = invoiceString.split(",");
                        return new Invoice(invoiceData[0], invoiceData[1], Double.parseDouble(invoiceData[2]));
                    })
                    .collect(Collectors.toList());
        } catch (IOException e) {
            // Do some logging, or maybe rethrow exception to notify caller...
        }

        return Collections.emptyList();

    }

}
