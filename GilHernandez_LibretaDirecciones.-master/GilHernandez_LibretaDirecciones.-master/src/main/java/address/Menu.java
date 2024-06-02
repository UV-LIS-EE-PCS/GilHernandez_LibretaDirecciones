package address;

import address.data.AddressBook;
import address.data.AddressEntry;
import java.util.List;
import java.util.Scanner;

/**
 * The Menu class provides a text-based menu for interacting with the Address
 * Book.
 */

public class Menu {
    private AddressBook addressBook;
    private Scanner scanner;

    /**
     * Constructs a Menu with the specified AddressBook.
     *
     * @param addressBook the AddressBook to be used
     */
    public Menu(AddressBook addressBook) {
        this.addressBook = addressBook;
        scanner = new Scanner(System.in);
    }

    /**
     * Displays the menu and processes the input.
     */
    public void displayMenu() {
        char choice;
        do {
            System.out.println("Menu:");
            System.out.println("a) Load entries from a file");
            System.out.println("b) Add");
            System.out.println("c) Delete");
            System.out.println("d) Search");
            System.out.println("e) Display");
            System.out.println("f) Exit");
            System.out.print("Select an option: \n");
            choice = scanner.next().charAt(0);
            scanner.nextLine();

            switch (choice) {
                case 'a':
                    readContactFromTextFile();
                    break;
                case 'b':
                    addEntry();
                    break;
                case 'c':
                    deleteEntry();
                    break;
                case 'd':
                    searchEntry();
                    break;
                case 'e':
                    displayAllEntries();
                    break;
                case 'f':
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid option");
            }
        } while (choice != 'f');
    }

    /**
     * Prompts the user to enter the name of a file to load contacts from and loads
     * the contacts.
     */
    public void readContactFromTextFile() {
        System.out.println("Enter the name of the file:");
        String filename = scanner.nextLine();
        addressBook.readFromATextFile(filename);

    }

    /**
     * Prompts the user to enter contact details and adds a new entry to the address
     * book.
     */
    private void addEntry() {
        System.out.println("Add a new contact:");
        System.out.print("Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Street: ");
        String street = scanner.nextLine();
        System.out.print("City: ");
        String city = scanner.nextLine();
        System.out.print("State: ");
        String state = scanner.nextLine();
        System.out.print("Postal Code: ");
        String postalCode = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();

        AddressEntry entry = new AddressEntry(firstName, lastName, street, city, state, postalCode, email, phone);
        addressBook.addEntry(entry);
    }

    /**
     * Prompts the user to enter a last name, searches for matching entries, and
     * allows the user to delete a selected entry.
     */
    private void deleteEntry() {
        System.out.print("Enter the last name to search and delete: ");
        String lastName = scanner.nextLine();
        List<AddressEntry> entries = addressBook.searchEntry(lastName);

        if (entries.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            for (int i = 0; i < entries.size(); i++) {
                System.out.println((i + 1) + ": " + entries.get(i));
            }
            System.out.print("Select the number of the contact to delete: ");
            try {
                String input = scanner.nextLine();
                int index = Integer.parseInt(input) - 1;
                if (index >= 0 && index < entries.size()) {
                    addressBook.removeEntry(entries.get(index));
                    System.out.println("Contact deleted.");
                } else {
                    System.out.println("Invalid selection. Please enter a number within the displayed range.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    /**
     * Prompts the user to enter a last name or part of a last name, searches for
     * matching entries, and displays the results.
     */
    private void searchEntry() {
        System.out.print("Enter the last name or the first few letters to search: ");
        String lastName = scanner.nextLine();
        List<AddressEntry> entries = addressBook.searchEntry(lastName);

        if (entries.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            System.out.println("Contacts found:");
            int count = 1;
            for (AddressEntry entry : entries) {
                System.out.println(count++ + " " + entry);
            }
        }
    }

    /**
     * Displays all entries in the address book.
     */
    private void displayAllEntries() {
        List<AddressEntry> entries = addressBook.getAllEntries();

        if (entries.isEmpty()) {
            System.out.println("No contacts to display.");
        } else {
            int count = 1;
            for (AddressEntry entry : entries) {
                System.out.println(count++ + ": " + entry);
            }
        }
    }
}
