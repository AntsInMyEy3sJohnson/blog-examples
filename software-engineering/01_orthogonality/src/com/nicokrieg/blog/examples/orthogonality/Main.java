package com.nicokrieg.blog.examples.orthogonality;

import com.nicokrieg.blog.examples.orthogonality.inappropriateintimacy.Customer3;
import com.nicokrieg.blog.examples.orthogonality.lowcouplinghighcohesion.Customer2;
import com.nicokrieg.blog.examples.orthogonality.telldontask.Account1;
import com.nicokrieg.blog.examples.orthogonality.telldontask.Account2;
import com.nicokrieg.blog.examples.orthogonality.telldontask.Customer4;
import com.nicokrieg.blog.examples.orthogonality.telldontask.Customer5;
import com.nicokrieg.blog.examples.orthogonality.tightcoupling.Customer1;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List.of(
                new Customer1(101, "John"),
                new Customer1(102, "Jane"),
                new Customer2(201, "Dave"),
                new Customer2(202, "Donna"),
                new Customer3(301, "Luke"),
                new Customer3(302, "Linda")
        ).forEach(System.out::println);


        // Bad!
        var customer4 = new Customer4(401, "Tylor", new Account1(965.75));
        List<Invoice> newInvoices = new ArrayList<>();
        var accountBalance = customer4.getAccount().getBalance();
        for (Invoice invoice : customer4.getInvoices()) {
            if (accountBalance > invoice.getAmount()) {
                accountBalance -= invoice.getAmount();
            } else {
                System.out.println("Insufficient funds, cannot pay invoice: %s".formatted(invoice));
                newInvoices.add(invoice);
            }
        }
        customer4.setInvoices(newInvoices);
        customer4.getAccount().setBalance(accountBalance);

        // Better:
        var customer5 = new Customer5(501, "Mike", new Account2(185.94));
        customer5.payInvoices();

    }

}
