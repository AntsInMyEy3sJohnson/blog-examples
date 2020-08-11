package com.nicokrieg.blog.examples.orthogonality.tightcoupling;

public class Main {

    public static void main(String[] args) {

        Customer customerJohn = new Customer("John");
        customerJohn.initInvoices();

        System.out.println("Hi.");

    }

}
