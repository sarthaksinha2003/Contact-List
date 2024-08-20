import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ContactList {

    long idValue = 11;

    //    Declaring list of Contact, named contacts.
    List<Contact> contacts;

    //    Creating a constructor to initialize, it will not auto generate.
    ContactList() {
        contacts = new LinkedList<>();
    }

    void showFunctions() {
        System.out.println("\nFunctions\n:");
        System.out.println("\t1. Add Contact");
        System.out.println("\t2. Read Contact");
        System.out.println("\t3. Read All Contacts");
        System.out.println("\t4. Update Contact");
        System.out.println("\t5. Delete Contact");
        System.out.println("\t6. Exit\n");
    }

    int selectContact() {
        System.out.println("\nIs it a student or faculty?");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type (student or faculty): ");
        String option = scanner.nextLine();
        if (option.equals("student")) return 1;
        else if (option.equals("faculty")) return 0;
        else {
            System.out.println("Invalid option!");
            return -1;
        }
    }

    String[] baseContactDetails() {
        String[] details = new String[3];
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nName: ");
        details[0] = scanner.nextLine();

        System.out.print("Phone number: ");
        details[1] = scanner.nextLine();

        System.out.print("Email: ");
        details[2] = scanner.nextLine();

        return details;

    }

    Student addStudent() {
        Scanner scanner = new Scanner(System.in);
        String[] details = baseContactDetails();

        System.out.print("Date of birth: ");
        String dateOfBirth = scanner.nextLine();

        return new Student(details[0], details[1], details[2], dateOfBirth);
    }

    Faculty addFaculty() {
        Scanner scanner = new Scanner(System.in);
        String[] details = baseContactDetails();

        System.out.print("Subject: ");
        String subject = scanner.nextLine();

        return new Faculty(details[0], details[1], details[2], subject);
    }

    void addContact() {
        int result = selectContact();
        if (result == -1) selectContact();
        else if (result == 0) {
            Faculty faculty = addFaculty();
            faculty.id = idValue;
            contacts.add(faculty);
            System.out.println("\nContact added! id: " + idValue++);
        }
        else {
            Student student = addStudent();
            student.id = idValue;
            contacts.add(student);
            System.out.println("\nContact added! id: " + idValue++);
        }
    }

    Contact getContact(long id) {
        for (Contact contact : contacts) {
            if (contact.id == id) return contact;
        }
        return null;
    }

    void printContact(long id) {
        try {
            System.out.println(getContact(id).toString());
        } catch (NullPointerException e) {
            System.out.println("\nContact not found!");
        }
    }

    void printContacts() {
        System.out.println();
        for (Contact contact : contacts) {
            System.out.println(contact.toString());
        }
        if (contacts.isEmpty()) System.out.println("No contacts!");
    }

    void updateContact(long id) {
        Contact currentContact = getContact(id);
        if (currentContact == null) {
            System.out.println("\nContact not found!");
        }
        else {
            printContact(currentContact.id);

            System.out.println("\nType:");
            System.out.println("\t1 for Name");
            System.out.println("\t2 for Phone");
            System.out.println("\t3 for Email");
            System.out.println("\t4 for Date of Birth (Student)");
            System.out.println("\t5 for Subject (Faculty)");

            System.out.print("Enter the option number: ");
            Scanner scanner = new Scanner(System.in);
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    System.out.print("Enter new name: ");
                    currentContact.name = scanner.nextLine();
                    break;
                case "2":
                    System.out.println("Enter new phone: ");
                    currentContact.phone = scanner.next();
                    break;
                case "3":
                    System.out.print("Enter new email: ");
                    currentContact.email = scanner.next();
                    break;
                case "4":
                    System.out.print("Enter new date of birth: ");
                    ((Student) currentContact).dateOfBirth = scanner.next();
                    break;
                case "5":
                    System.out.print("Enter new subject: ");
                    ((Faculty) currentContact).subject = scanner.next();
                    break;
                default:
                    System.out.println("Invalid option!");
            }
            System.out.println("\nContact(" + currentContact.id +") updated!");
        }
    }

    void deleteContact(Contact contact) {
        try {
            contacts.remove(contact);
            System.out.println("\nContact(" + contact.id +") deleted!");
        } catch (NullPointerException e) {
            System.out.println("\nContact not found!");
        }
    }
}
