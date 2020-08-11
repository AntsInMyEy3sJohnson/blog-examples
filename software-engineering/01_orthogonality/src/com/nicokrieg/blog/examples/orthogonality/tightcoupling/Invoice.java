package com.nicokrieg.blog.examples.orthogonality.tightcoupling;

public class Invoice {

    private final String date;
    private final String subject;
    private final double amount;

    public Invoice(String date, String subject, double amount) {
        this.date = date;
        this.subject = subject;
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public String getSubject() {
        return subject;
    }

    public double getAmount() {
        return amount;
    }
}
