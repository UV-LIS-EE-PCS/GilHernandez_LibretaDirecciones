package address;

import address.data.AddressBook;
import address.data.AddressEntry;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private AddressBook addressBook;
    private Scanner scanner;

    public Menu(AddressBook addressBook) {
        this.addressBook = addressBook;
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        char choice;
        do {
            System.out.println("Menu:");
            System.out.println("a) Cargar entradas desde un archivo");
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
                    loadFromFile();
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
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (choice != 'f');
    }

    private void loadFromFile() {
        System.out.print("Enter the file name: ");
        String fileName = scanner.nextLine();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 8) {
                    String firstName = data[0];
                    String lastName = data[1];
                    String street = data[2];
                    String city = data[3];
                    String state = data[4];
                    String postalCode = data[5];
                    String email = data[6];
                    String phone = data[7];
                    AddressEntry entry = new AddressEntry(firstName, lastName, street, city, state, postalCode, email,
                            phone);
                    addressBook.addEntry(entry);
                } else {
                    System.out.println("Invalid line format: " + line);
                }
            }
            System.out.println("Entries loaded from the file.");
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

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

    private void searchEntry() {
        System.out.print("Enter the last name to search: ");
        String lastName = scanner.nextLine();
        List<AddressEntry> entries = addressBook.searchEntry(lastName);

        if (entries.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            for (AddressEntry entry : entries) {
                System.out.println(entry);
            }
        }
    }

    private void displayAllEntries() {
        List<AddressEntry> entries = addressBook.getAllEntries();

        if (entries.isEmpty()) {
            System.out.println("No contacts to display.");
        } else {
            for (AddressEntry entry : entries) {
                System.out.println(entry);
            }
        }
    }
}
