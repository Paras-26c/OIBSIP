package atm;

import java.util.ArrayList;

public class BankAccount {
    private double balance;
    private ArrayList<Transaction> history = new ArrayList<>();

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amt) {
        balance += amt;
        history.add(new Transaction("Deposit", amt));
    }

    public boolean withdraw(double amt) {
        if (amt > balance) return false;
        balance -= amt;
        history.add(new Transaction("Withdraw", amt));
        return true;
    }

    public boolean transfer(double amt, BankAccount receiver) {
        if (amt > balance) return false;
        balance -= amt;
        receiver.deposit(amt);
        history.add(new Transaction("Transfer", amt));
        return true;
    }

    public void printHistory() {
        if (history.isEmpty()) {
            System.out.println("No transactions yet.");
            return;
        }
        for (Transaction t : history) {
            System.out.println(t);
        }
    }
}

