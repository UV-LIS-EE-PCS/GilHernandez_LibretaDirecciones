package address.data;

import java.util.Objects;

/**
 * This class represents a single entry in an address book.
 */

public class AddressEntry {
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String email;
    private String phone;

    /**
     * Default constructor.
     */
    public AddressEntry() {

    }

    /**
     * Constructs a new AddressEntry with the specified details.
     *
     * @param firstName  the first name of the contact
     * @param lastName   the last name of the contact
     * @param street     the street address of the contact
     * @param city       the city of the contact
     * @param state      the state of the contact
     * @param postalCode the postal code of the contact
     * @param email      the email address of the contact
     * @param phone      the phone number of the contact
     */
    public AddressEntry(String firstName, String lastName, String street, String city, String state, String postalCode,
            String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.email = email;
        this.phone = phone;
    }

    // Getters and setters for each field
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Returns a string representation of the AddressEntry.
     *
     * @return a formatted string containing the contact's details
     */
    @Override
    public String toString() {
        return String.format("Name: %s %s\nStreet: %s\nCity: %s\nState: %s\nPostal Code: %s\nEmail: %s\nPhone: %s\n",
                firstName, lastName, street, city, state, postalCode, email, phone);
    }

    /**
     * Checks if this AddressEntry is equal to another object.
     *
     * @param o the object to compare to
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        AddressEntry that = (AddressEntry) o;
        return Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(street, that.street) &&
                Objects.equals(city, that.city) &&
                Objects.equals(state, that.state) &&
                Objects.equals(postalCode, that.postalCode) &&
                Objects.equals(email, that.email) &&
                Objects.equals(phone, that.phone);
    }

    /**
     * Returns a hash code value for the AddressEntry.
     *
     * @return the hash code value
     */
    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, street, city, state, postalCode, email, phone);
    }

}
