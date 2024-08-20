import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static long idChecker() {
        Scanner scanner = new Scanner(System.in);
        long value = 0;
        try {
            value = scanner.nextLong();
        } catch (InputMismatchException e) {
            System.out.println("\nEnter a valid id!");
        }
        return value;
    }

    public static void main(String[] args) throws IOException {
        ContactList list = new ContactList();

        System.out.println("\nWelcome to the contact-list-app!");

        boolean check = true;

        while (check) {
            list.showFunctions();

            Scanner scanner = new Scanner(System.in);
            System.out.print("Select an option: ");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    list.addContact();
                    break;
                case "2":
                    System.out.print("\nEnter id of the contact: ");
                    list.printContact(idChecker());
                    break;
                case "3":
                    list.printContacts();
                    break;
                case "4":
                    System.out.print("\nEnter id of the contact: ");
                    list.updateContact(idChecker());
                    break;
                case "5":
                    System.out.print("\nEnter id of the contact: ");
                    list.deleteContact(list.getContact(idChecker()));
                    break;
                case "6":
                    check = false;
                    break;
                default:
                    System.out.println("\nInvalid option!");
            }
            if (check) {
                System.out.print("\nPress enter to continue...");
                System.in.read();
                System.in.skip(System.in.available());
            }
        }
    }
}
