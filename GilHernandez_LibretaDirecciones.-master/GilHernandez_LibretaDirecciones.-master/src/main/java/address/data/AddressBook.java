import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    private List<AddressEntry> entries;

    public AddressBook() {
        this.entries = new ArrayList<>();
    }

    public void addEntry(AddressEntry entry) {
        if (!isDuplicate(entry)) {
            entries.add(entry);
            System.out.println("Contacto agregado.");
        } else {
            System.out.println("Este contacto ya existe.");
        }
    }

    public void removeEntry(AddressEntry entry) {
        entries.remove(entry);
    }

    public List<AddressEntry> searchEntry(String lastName) {
        List<AddressEntry> results = new ArrayList<>();
        for (AddressEntry entry : entries) {
            if (entry.getLastName().startsWith(lastName)) {
                results.add(entry);
            }
        }
        return results;
    }

    public List<AddressEntry> getAllEntries() {
        return new ArrayList<>(entries);
    }

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
}
