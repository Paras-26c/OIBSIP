package atm;

import java.util.Scanner;

public class ATMOperations {

    public void showMenu(User user) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = user.getAccount();

        while (true) {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    account.printHistory();
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double w = sc.nextDouble();
                    if (account.withdraw(w))
                        System.out.println("Withdraw successful.");
                    else
                        System.out.println("Insufficient balance.");
                    break;

                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double d = sc.nextDouble();
                    account.deposit(d);
                    System.out.println("Deposit successful.");
                    break;

                case 4:
                    System.out.print("Enter amount to transfer: ");
                    double t = sc.nextDouble();

                    // dummy receiver account
                    BankAccount receiver = new BankAccount(0);

                    if (account.transfer(t, receiver))
                        System.out.println("Transfer successful.");
                    else
                        System.out.println("Transfer failed, insufficient balance.");
                    break;

                case 5:
                    System.out.println("Thank you for using ATM!");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

