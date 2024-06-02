package address;

import address.data.AddressBook;

/**
 * The main application class for the Address Book application.
 */

public class AddressBookApplication {
    private AddressBook addressBook;
    private Menu menu;

    /**
     * Constructs an AddressBookApplication with a new AddressBook and Menu.
     */
    public AddressBookApplication() {
        addressBook = new AddressBook();
        menu = new Menu(addressBook);
    }

    /**
     * Starts the Address Book application by displaying the menu.
     */
    public void start() {
        menu.displayMenu();
    }

    /**
     * The main method, which serves as the entry point for the application.
     *
     * @param args the command-line arguments
     */

    public static void main(String[] args) {
        AddressBookApplication app = new AddressBookApplication();
        app.start();
    }

}