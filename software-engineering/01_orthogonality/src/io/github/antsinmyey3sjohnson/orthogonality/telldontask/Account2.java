package io.github.antsinmyey3sjohnson.orthogonality.telldontask;

public class Account2 {

    private double balance;

    public Account2(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deduct(double amount) {
        if (balance > amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
}
