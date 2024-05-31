package test;

import address.data.AddressBook;
import address.data.AddressEntry;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MenuTest {
    private AddressBook addressBook;
    private Menu menu;

    @Before
    public void setUp() {
        addressBook = new AddressBook();
        menu = new Menu(addressBook);
    }

    @Test
    public void testLoadFromFile() {
        String input = "test_data.txt";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        menu.loadFromFile();

        List<AddressEntry> entries = addressBook.getAllEntries();
        assertEquals(2, entries.size());
    }

    @Test
    public void testAddEntry() {
        String input = "John\nDoe\n1st Street\nSomewhere\nSomeState\n12345\njohn.doe@example.com\n123456789";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        menu.addEntry();

        List<AddressEntry> entries = addressBook.getAllEntries();
        assertEquals(1, entries.size());

        AddressEntry addedEntry = entries.get(0);
        assertEquals("John", addedEntry.getFirstName());
        assertEquals("Doe", addedEntry.getLastName());
        assertEquals("1st Street", addedEntry.getStreet());
        assertEquals("Somewhere", addedEntry.getCity());
        assertEquals("SomeState", addedEntry.getState());
        assertEquals("12345", addedEntry.getPostalCode());
        assertEquals("john.doe@example.com", addedEntry.getEmail());
        assertEquals("123456789", addedEntry.getPhone());
    }

    @Test
    public void testDeleteEntry() {
        AddressEntry entry = new AddressEntry("John", "Doe", "1st Street", "Somewhere", "SomeState", "12345",
                "john.doe@example.com", "123456789");
        addressBook.addEntry(entry);

        String input = "Doe";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        menu.deleteEntry();

        List<AddressEntry> entries = addressBook.getAllEntries();
        assertTrue(entries.isEmpty());
    }

    @Test
    public void testSearchEntry() {
        AddressEntry entry1 = new AddressEntry("John", "Doe", "1st Street", "Somewhere", "SomeState", "12345",
                "john.doe@example.com", "123456789");
        AddressEntry entry2 = new AddressEntry("Jane", "Doe", "2nd Street", "Somewhere", "SomeState", "54321",
                "jane.doe@example.com", "987654321");
        addressBook.addEntry(entry1);
        addressBook.addEntry(entry2);

        String input = "Doe";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        menu.searchEntry();

        // Assuming search results are printed to console
    }

    @Test
    public void testDisplayAllEntries() {
        AddressEntry entry1 = new AddressEntry("John", "Doe", "1st Street", "Somewhere", "SomeState", "12345",
                "john.doe@example.com", "123456789");
        AddressEntry entry2 = new AddressEntry("Jane", "Doe", "2nd Street", "Somewhere", "SomeState", "54321",
                "jane.doe@example.com", "987654321");
        addressBook.addEntry(entry1);
        addressBook.addEntry(entry2);

        menu.displayAllEntries();

        // Assuming entries are printed to console
    }
}