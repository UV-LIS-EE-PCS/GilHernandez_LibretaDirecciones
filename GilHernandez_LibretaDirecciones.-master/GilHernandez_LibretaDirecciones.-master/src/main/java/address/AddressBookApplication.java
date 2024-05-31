import address.data.AddressBook;

public class AddressBookApplication {
    private AddressBook addressBook;
    private Menu menu;

    public AddressBookApplication() {
        addressBook = new AddressBook();
        menu = new Menu(addressBook);
    }

    public void start() {
        menu.displayMenu();
    }

    public static void main(String[] args) {
        AddressBookApplication app = new AddressBookApplication();
        app.start();
    }

}