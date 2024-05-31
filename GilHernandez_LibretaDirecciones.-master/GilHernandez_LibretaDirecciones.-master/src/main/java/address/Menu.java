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
            System.out.println("b) Agregar");
            System.out.println("c) Eliminar");
            System.out.println("d) Buscar");
            System.out.println("e) Mostrar");
            System.out.println("f) Salir");
            System.out.print("Seleccione una opción: ");
            choice = scanner.next().charAt(0);
            scanner.nextLine(); // Consumir la nueva línea restante

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
        System.out.print("Ingrese el nombre del archivo: ");
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
                    System.out.println("Formato de línea inválido: " + line);
                }
            }
            System.out.println("Entradas cargadas desde el archivo.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    private void addEntry() {
        System.out.println("Agregar nuevo contacto:");
        System.out.print("Nombre: ");
        String firstName = scanner.nextLine();
        System.out.print("Apellido: ");
        String lastName = scanner.nextLine();
        System.out.print("Calle: ");
        String street = scanner.nextLine();
        System.out.print("Ciudad: ");
        String city = scanner.nextLine();
        System.out.print("Estado: ");
        String state = scanner.nextLine();
        System.out.print("Código Postal: ");
        String postalCode = scanner.nextLine();
        System.out.print("Correo Electrónico: ");
        String email = scanner.nextLine();
        System.out.print("Teléfono: ");
        String phone = scanner.nextLine();

        AddressEntry entry = new AddressEntry(firstName, lastName, street, city, state, postalCode, email, phone);
        addressBook.addEntry(entry);
    }

    private void deleteEntry() {
        System.out.print("Ingrese el apellido para buscar y eliminar: ");
        String lastName = scanner.nextLine();
        List<AddressEntry> entries = addressBook.searchEntry(lastName);

        if (entries.isEmpty()) {
            System.out.println("No se encontraron contactos.");
        } else {
            for (int i = 0; i < entries.size(); i++) {
                System.out.println((i + 1) + ": " + entries.get(i));
            }
            System.out.print("Seleccione el número del contacto a eliminar: ");
            try {
                String input = scanner.nextLine();
                int index = Integer.parseInt(input) - 1;
                if (index >= 0 && index < entries.size()) {
                    addressBook.removeEntry(entries.get(index));
                    System.out.println("Contacto eliminado.");
                } else {
                    System.out.println("Selección inválida. Por favor, ingrese un número dentro del rango mostrado.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
            }
        }
    }

    private void searchEntry() {
        System.out.print("Ingrese el inicio del apellido para buscar: ");
        String lastName = scanner.nextLine();
        List<AddressEntry> entries = addressBook.searchEntry(lastName);

        if (entries.isEmpty()) {
            System.out.println("No se encontraron contactos.");
        } else {
            for (AddressEntry entry : entries) {
                System.out.println(entry);
            }
        }
    }

    private void displayAllEntries() {
        List<AddressEntry> entries = addressBook.getAllEntries();

        if (entries.isEmpty()) {
            System.out.println("No hay contactos para mostrar.");
        } else {
            for (AddressEntry entry : entries) {
                System.out.println(entry);
            }
        }
    }
}
