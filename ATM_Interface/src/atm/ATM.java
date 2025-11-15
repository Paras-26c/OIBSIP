package atm;

import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Dummy user
        User user = new User("user123", "1234", new BankAccount(10000));

        System.out.println("===== Welcome to Java ATM =====");

        System.out.print("Enter User ID: ");
        String uid = sc.nextLine();

        System.out.print("Enter PIN: ");
        String pin = sc.nextLine();

        if (user.validate(uid, pin)) {
            System.out.println("Login Successful!");
            ATMOperations ops = new ATMOperations();
            ops.showMenu(user);

        } else {
            System.out.println("Invalid User ID or PIN!");
        }
    }
}

