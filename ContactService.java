package contact;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Luis Tomassini
 * Course: CS 320
 * Assignment: Contact Service
 *
 * The ContactService class manages Contact objects using
 * an in-memory HashMap. It ensures that each contact has
 * a unique ID and provides controlled update operations.
 */
public class ContactService {

    // Stores contacts using contactId as the key
    private final Map<String, Contact> contacts = new HashMap<>();

    /**
     * Adds a new contact to the service.
     */
    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null.");
        }

        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("A contact with this ID already exists.");
        }

        contacts.put(contact.getContactId(), contact);
    }

    /**
     * Deletes a contact by ID.
     */
    public void deleteContact(String contactId) {
        if (contactId == null) {
            throw new IllegalArgumentException("Contact ID cannot be null.");
        }

        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact does not exist.");
        }

        contacts.remove(contactId);
    }

    /**
     * Updates the first name of an existing contact.
     */
    public void updateFirstName(String contactId, String firstName) {
        getContact(contactId).setFirstName(firstName);
    }

    /**
     * Updates the last name of an existing contact.
     */
    public void updateLastName(String contactId, String lastName) {
        getContact(contactId).setLastName(lastName);
    }

    /**
     * Updates the phone number of an existing contact.
     */
    public void updatePhone(String contactId, String phone) {
        getContact(contactId).setPhone(phone);
    }

    /**
     * Updates the address of an existing contact.
     */
    public void updateAddress(String contactId, String address) {
        getContact(contactId).setAddress(address);
    }

    /**
     * Retrieves a contact by ID.
     */
    public Contact getContact(String contactId) {
        if (contactId == null) {
            throw new IllegalArgumentException("Contact ID cannot be null.");
        }

        Contact contact = contacts.get(contactId);

        if (contact == null) {
            throw new IllegalArgumentException("Contact does not exist.");
        }

        return contact;
    }
}