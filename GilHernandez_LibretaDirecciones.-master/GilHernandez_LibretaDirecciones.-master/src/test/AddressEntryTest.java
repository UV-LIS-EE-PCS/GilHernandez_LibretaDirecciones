package test;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddressEntryTest {
    private AddressEntry entry1;
    private AddressEntry entry2;
    private AddressEntry entry3;

    @Before
    public void setUp() {
        entry1 = new AddressEntry("Carrie", "Bradshaw", "5th. Avenue", "Manhattan", "New York", "36253",
                "carrie.brdsh@ignore.com", "5547658943");
        entry2 = new AddressEntry("John", "Doe", "1st Street", "Somewhere", "SomeState", "12345",
                "john.doe@example.com", "123456789");
        entry3 = new AddressEntry("Carrie", "Bradshaw", "5th. Avenue", "Manhattan", "New York", "36253",
                "carrie.brdsh@ignore.com", "5547658943");
    }

    @Test
    public void testGetFirstName() {
        assertEquals("Carrie", entry1.getFirstName());
    }

    @Test
    public void testSetFirstName() {
        entry1.setFirstName("Caroline");
        assertEquals("Caroline", entry1.getFirstName());
    }

    @Test
    public void testGetLastName() {
        assertEquals("Bradshaw", entry1.getLastName());
    }

    @Test
    public void testSetLastName() {
        entry1.setLastName("Smith");
        assertEquals("Smith", entry1.getLastName());
    }

    @Test
    public void testGetStreet() {
        assertEquals("5th. Avenue", entry1.getStreet());
    }

    @Test
    public void testSetStreet() {
        entry1.setStreet("6th. Avenue");
        assertEquals("6th. Avenue", entry1.getStreet());
    }

    @Test
    public void testGetCity() {
        assertEquals("Manhattan", entry1.getCity());
    }

    @Test
    public void testSetCity() {
        entry1.setCity("Brooklyn");
        assertEquals("Brooklyn", entry1.getCity());
    }

    @Test
    public void testGetState() {
        assertEquals("New York", entry1.getState());
    }

    @Test
    public void testSetState() {
        entry1.setState("California");
        assertEquals("California", entry1.getState());
    }

    @Test
    public void testGetPostalCode() {
        assertEquals("36253", entry1.getPostalCode());
    }

    @Test
    public void testSetPostalCode() {
        entry1.setPostalCode("54321");
        assertEquals("54321", entry1.getPostalCode());
    }

    @Test
    public void testGetEmail() {
        assertEquals("carrie.brdsh@ignore.com", entry1.getEmail());
    }

    @Test
    public void testSetEmail() {
        entry1.setEmail("caroline.brdsh@ignore.com");
        assertEquals("caroline.brdsh@ignore.com", entry1.getEmail());
    }

    @Test
    public void testGetPhone() {
        assertEquals("5547658943", entry1.getPhone());
    }

    @Test
    public void testSetPhone() {
        entry1.setPhone("987654321");
        assertEquals("987654321", entry1.getPhone());
    }

    @Test
    public void testToString() {
        String expected = "Name: Carrie Bradshaw\nStreet: 5th. Avenue\nCity: Manhattan\nState: New York\nPostal Code: 36253\nEmail: carrie.brdsh@ignore.com\nPhone: 5547658943";
        assertEquals(expected, entry1.toString());
    }

    @Test
    public void testEquals() {
        assertTrue(entry1.equals(entry3));
        assertFalse(entry1.equals(entry2));
    }

    @Test
    public void testHashCode() {
        assertEquals(entry1.hashCode(), entry3.hashCode());
        assertNotEquals(entry1.hashCode(), entry2.hashCode());
    }
}
