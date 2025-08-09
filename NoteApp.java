import java.io.*;
import java.util.Scanner;

public class NoteApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        String filename = "notes.txt";

        do {
            System.out.println("\nNote Manager:");
            System.out.println("1. Add Note");
            System.out.println("2. View Notes");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter your note: ");
                    String note = scanner.nextLine();
                    try (FileWriter writer = new FileWriter(filename, true)) {
                        writer.write(note + System.lineSeparator());
                        System.out.println("Note saved.");
                    } catch (IOException e) {
                        System.out.println("Error writing to file.");
                    }
                    break;

                case 2:
                    System.out.println("Your Notes:");
                    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            System.out.println("- " + line);
                        }
                    } catch (IOException e) {
                        System.out.println("Error reading file or file not found.");
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 3);

        scanner.close();
    }
}
