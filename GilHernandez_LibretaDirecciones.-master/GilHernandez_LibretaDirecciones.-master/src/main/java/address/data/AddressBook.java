package address.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The AddressBook class manages the list of AddressEntry objects.
 */

public class AddressBook {
    private List<AddressEntry> entries;

    /**
     * Constructs an AddressBook with an empty list of entries.
     */
    public AddressBook() {
        this.entries = new ArrayList<>();
    }

    /**
     * Adds an entry to the address book if it is not a duplicate.
     *
     * @param entry the AddressEntry to add
     */
    public void addEntry(AddressEntry entry) {
        if (!isDuplicate(entry)) {
            entries.add(entry);
            System.out.println("Add contact.");
        } else {
            System.out.println("This contact already exists");
        }
    }

    /**
     * Removes an entry from the address book.
     *
     * @param entry the AddressEntry to remove
     */
    public void removeEntry(AddressEntry entry) {
        entries.remove(entry);
    }

    /**
     * Searches for entries by last name.
     *
     * @param lastName the last name to search for
     * @return a list of AddressEntry objects that match the search criteria
     */
    public List<AddressEntry> searchEntry(String lastName) {
        List<AddressEntry> results = new ArrayList<>();
        for (AddressEntry entry : entries) {
            if (entry.getLastName().startsWith(lastName)) {
                results.add(entry);
            }
        }
        return results;
    }

    /**
     * Returns all entries in the address book.
     *
     * @return a list of all AddressEntry objects
     */
    public List<AddressEntry> getAllEntries() {
        return new ArrayList<>(entries);
    }

    /**
     * Checks if the given entry is a duplicate.
     *
     * @param newEntry the AddressEntry to check
     * @return true if the entry is a duplicate, false otherwise
     */
    private boolean isDuplicate(AddressEntry newEntry) {
        for (AddressEntry entry : entries) {
            if (entry.getFirstName().equalsIgnoreCase(newEntry.getFirstName()) &&
                    entry.getLastName().equalsIgnoreCase(newEntry.getLastName()) &&
                    entry.getEmail().equalsIgnoreCase(newEntry.getEmail()) &&
                    entry.getPhone().equalsIgnoreCase(newEntry.getPhone())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Reads entries from a text file and adds them to the address book.
     *
     * @param filename the name of the file to read from
     */
    public void readFromATextFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String[] contactData = new String[8];
            int index = 0;
            String line;

            while ((line = br.readLine()) != null) {
                contactData[index] = line.trim();
                index++;

                if (index == 8) {
                    AddressEntry entry = new AddressEntry(contactData[0], contactData[1], contactData[2],
                            contactData[3], contactData[4], contactData[5], contactData[6], contactData[7]);
                    addEntry(entry);
                    index = 0;
                    contactData = new String[8];
                }
            }

            if (index != 0) {
                System.err.println("Warning: Incomplete address entry found at the end of the file.");
            }
        } catch (IOException e) {
            System.err.println("Error loading the file: " + e.getMessage());
        }
    }
}
