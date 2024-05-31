package test;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AddressBookTest {
    private AddressBook addressBook;
    private AddressEntry entry1;
    private AddressEntry entry2;

    @Before
    public void setUp() {
        addressBook = new AddressBook();
        entry1 = new AddressEntry("Carrie", "Bradshaw", "carrie.brdsh@ignore.com", "5547658943", "5th. Avenue",
                "Manhattan", "New York", "36253");
        entry2 = new AddressEntry("John", "Doe", "john.doe@example.com", "123456789", "1st Street", "Somewhere",
                "SomeState", "12345");
    }

    @Test
    public void testAddEntry() {
        addressBook.addEntry(entry1);
        List<AddressEntry> entries = addressBook.getAllEntries();
        assertEquals(1, entries.size());
        assertEquals(entry1, entries.get(0));
    }

    @Test
    public void testAddDuplicateEntry() {
        addressBook.addEntry(entry1);
        addressBook.addEntry(entry1); // This should not add the entry again
        List<AddressEntry> entries = addressBook.getAllEntries();
        assertEquals(1, entries.size());
    }

    @Test
    public void testRemoveEntry() {
        addressBook.addEntry(entry1);
        addressBook.removeEntry(entry1);
        List<AddressEntry> entries = addressBook.getAllEntries();
        assertEquals(0, entries.size());
    }

    @Test
    public void testSearchEntry() {
        addressBook.addEntry(entry1);
        addressBook.addEntry(entry2);
        List<AddressEntry> results = addressBook.searchEntry("Bradshaw");
        assertEquals(1, results.size());
        assertTrue(results.contains(entry1));
    }

    @Test
    public void testGetAllEntries() {
        addressBook.addEntry(entry1);
        addressBook.addEntry(entry2);
        List<AddressEntry> entries = addressBook.getAllEntries();
        assertEquals(2, entries.size());
        assertTrue(entries.contains(entry1));
        assertTrue(entries.contains(entry2));
    }

    @Test
    public void testIsDuplicate() {
        addressBook.addEntry(entry1);
        AddressEntry duplicate = new AddressEntry("Carrie", "Bradshaw", "carrie.brdsh@ignore.com", "5547658943",
                "5th. Avenue", "Manhattan", "New York", "36253");
        assertTrue(addressBook.isDuplicate(duplicate));
    }
}
