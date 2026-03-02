package contact;

import java.util.Objects;

/**
 * Author: Luis Tomassini
 * Course: CS 320
 * Assignment: Contact Service
 *
 * The Contact class represents a single contact record.
 * Each contact has a unique, non-updatable contactId.
 * Other fields may be updated with proper validation.
 */
public class Contact {

    // Unique identifier for the contact (cannot be changed after creation)
    private final String contactId;

    // Updatable contact fields
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    /**
     * Constructs a Contact object with required validation.
     */
    public Contact(String contactId, String firstName, String lastName,
                   String phone, String address) {

        validateContactId(contactId);
        validateFirstName(firstName);
        validateLastName(lastName);
        validatePhone(phone);
        validateAddress(address);

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Getters
    public String getContactId() { return contactId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }

    // Setters with validation
    public void setFirstName(String firstName) {
        validateFirstName(firstName);
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        validateLastName(lastName);
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        validatePhone(phone);
        this.phone = phone;
    }

    public void setAddress(String address) {
        validateAddress(address);
        this.address = address;
    }

    // Validation Methods

    private static void validateContactId(String id) {
        if (id == null || id.length() > 10) {
            throw new IllegalArgumentException("Contact ID must be non-null and at most 10 characters.");
        }
    }

    private static void validateFirstName(String name) {
        if (name == null || name.length() > 10) {
            throw new IllegalArgumentException("First name must be non-null and at most 10 characters.");
        }
    }

    private static void validateLastName(String name) {
        if (name == null || name.length() > 10) {
            throw new IllegalArgumentException("Last name must be non-null and at most 10 characters.");
        }
    }

    private static void validatePhone(String phone) {
        if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
            throw new IllegalArgumentException("Phone number must be exactly 10 numeric digits.");
        }
    }

    private static void validateAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address must be non-null and at most 30 characters.");
        }
    }

    /**
     * Contacts are considered equal if they share the same contactId.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return Objects.equals(contactId, contact.contactId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactId);
    }
}