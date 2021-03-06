package io.github.antsinmyey3sjohnson.orthogonality.lowcouplinghighcohesion;

import io.github.antsinmyey3sjohnson.orthogonality.Invoice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class InvoiceReader2 {

    private static InvoiceReader2 invoiceReader2;

    private InvoiceReader2() {
    }

    public static InvoiceReader2 getInstance() {
        if (Objects.isNull(invoiceReader2)) {
            invoiceReader2 = new InvoiceReader2();
        }
        return invoiceReader2;
    }

    public List<Invoice> getInvoicesByCustomerID(long customerID) {

        try {
            return Files.lines(Paths.get(String.format("invoices/%d.csv", customerID)))
                    .map(invoiceString -> {
                        var invoiceData = invoiceString.split(",");
                        return new Invoice(invoiceData[0], invoiceData[1], Double.parseDouble(invoiceData[2]));
                    })
                    .collect(Collectors.toList());
        } catch (IOException e) {
            // Do some logging, or maybe rethrow exception to notify caller...
        }

        return Collections.emptyList();

    }

}
