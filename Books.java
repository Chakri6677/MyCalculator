import java.util.*;

class Publication {
    private String label;
    private String writer;
    private boolean taken;

    public Publication(String label, String writer) {
        this.label = label;
        this.writer = writer;
        this.taken = false;
    }

    public String getLabel() {
        return label;
    }

    public boolean isTaken() {
        return taken;
    }

    public void markTaken() {
        this.taken = true;
    }

    public void markReturned() {
        this.taken = false;
    }

    public String toString() {
        return label + " by " + writer + (taken ? " [Checked Out]" : " [In Stock]");
    }
}

class Person {
    private String identity;

    public Person(String identity) {
        this.identity = identity;
    }

    public String getIdentity() {
        return identity;
    }
}

class Archive {
    private List<Publication> catalog = new ArrayList<>();

    public void insert(Publication item) {
        catalog.add(item);
    }

    public void display() {
        if (catalog.isEmpty()) {
            System.out.println("Archive is empty.");
            return;
        }
        for (Publication p : catalog) {
            System.out.println(p);
        }
    }

    public void checkout(String label, Person p) {
        for (Publication pub : catalog) {
            if (pub.getLabel().equalsIgnoreCase(label) && !pub.isTaken()) {
                pub.markTaken();
                System.out.println(p.getIdentity() + " checked out \"" + label + "\"");
                return;
            }
        }
        System.out.println("Item unavailable.");
    }

    public void checkin(String label, Person p) {
        for (Publication pub : catalog) {
            if (pub.getLabel().equalsIgnoreCase(label) && pub.isTaken()) {
                pub.markReturned();
                System.out.println(p.getIdentity() + " returned \"" + label + "\"");
                return;
            }
        }
        System.out.println("Return failed.");
    }
}

public class Books {
    public static void main(String[] args) {
        Archive system = new Archive();
        Person client = new Person("Chak");
        Scanner input = new Scanner(System.in);
        int task;

        system.insert(new Publication("Core Java", "Chakri"));
        system.insert(new Publication("Javac", "Chakradhar"));

        do {
            System.out.println("\nOptions:");
            System.out.println("1. View Items");
            System.out.println("2. Borrow Item");
            System.out.println("3. Return Item");
            System.out.println("4. Quit");
            System.out.print("Choose: ");
            task = input.nextInt();
            input.nextLine();

            switch (task) {
                case 1:
                    system.display();
                    break;
                case 2:
                    System.out.print("Enter title to borrow: ");
                    String getTitle = input.nextLine();
                    system.checkout(getTitle, client);
                    break;
                case 3:
                    System.out.print("Enter title to return: ");
                    String returnTitle = input.nextLine();
                    system.checkin(returnTitle, client);
                    break;
                case 4:
                    System.out.println("Session ended.");
                    break;
                default:
                    System.out.println("Invalid entry.");
            }
        } while (task != 4);

        input.close();
    }
}
