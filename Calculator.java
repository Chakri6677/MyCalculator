import java.util.Scanner;
public class CalculatorApp {
    public static double performAddition(Scanner sc, int n) {
        double sum = 0;
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter number " + i + ": ");
            sum += sc.nextDouble();
        }
        return sum;
    }
    public static double performSubtraction(Scanner sc, int n) {
        System.out.print("Enter number 1: ");
        double result = sc.nextDouble();
        for (int i = 2; i <= n; i++) {
            System.out.print("Enter number " + i + ": ");
            result -= sc.nextDouble();
        }
        return result;
    }
    public static double performMultiplication(Scanner sc, int n) {
        double result = 1;
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter number " + i + ": ");
            result *= sc.nextDouble();
        }
        return result;
    }
    public static double performDivision(Scanner sc, int n) {
        System.out.print("Enter number 1: ");
        double result = sc.nextDouble();
        for (int i = 2; i <= n; i++) {
            System.out.print("Enter number " + i + ": ");
            double num = sc.nextDouble();
            if (num == 0) {
                System.out.println("Cannot divide by zero. Skipping.");
                continue;
            }
            result /= num;
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean keepRunning = true;
        System.out.println("Welcome to Java Calculator");
        while (keepRunning) {
            System.out.println("\nSelect operation:");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Exit");
            System.out.print("Your choice: ");
            int option = sc.nextInt();
            if (option >= 1 && option <= 4) {
                System.out.print("How many numbers? ");
                int n = sc.nextInt();
                if (n < 2) {
                    System.out.println("Need at least 2 numbers.");
                    continue;
                }
                double answer = 0;
                switch (option) {
                    case 1:
                        answer = performAddition(sc, n);
                        break;
                    case 2:
                        answer = performSubtraction(sc, n);
                        break;
                    case 3:
                        answer = performMultiplication(sc, n);
                        break;
                    case 4:
                        answer = performDivision(sc, n);
                        break;
                }
                System.out.println("Result: " + answer);
            } else if (option == 5) {
                keepRunning = false;
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid option.");
            }
        }
    }
}
