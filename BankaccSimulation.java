import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter account holder name: ");
        String name = input.nextLine();

        Account acc = new Account(name);

        while (true) {
            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Show Balance");
            System.out.println("4. Show History");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = input.nextInt();

            if (choice == 1) {
                System.out.print("Enter amount to deposit: ");
                double amt = input.nextDouble();
                acc.deposit(amt);
            } else if (choice == 2) {
                System.out.print("Enter amount to withdraw: ");
                double amt = input.nextDouble();
                acc.withdraw(amt);
            } else if (choice == 3) {
                System.out.println("Balance: " + acc.getBalance());
            } else if (choice == 4) {
                List<String> history = acc.getHistory();
                if (history.isEmpty()) {
                    System.out.println("No transactions yet.");
                } else {
                    for (String entry : history) {
                        System.out.println(entry);
                    }
                }
            } else if (choice == 5) {
                System.out.println("Exiting.");
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }

        input.close();
    }
}

class Account {
    private String holder;
    private double funds;
    private List<String> log;

    public Account(String holder) {
        this.holder = holder;
        this.funds = 0.0;
        this.log = new ArrayList<>();
    }

    public void deposit(double amount) {
        if (amount > 0) {
            funds += amount;
            log.add("Added: " + amount);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= funds) {
            funds -= amount;
            log.add("Removed: " + amount);
        } else {
            log.add("Failed Withdrawal Attempt: " + amount);
        }
    }

    public double getBalance() {
        return funds;
    }

    public List<String> getHistory() {
        return log;
    }

    public String getOwner() {
        return holder;
    }
}
