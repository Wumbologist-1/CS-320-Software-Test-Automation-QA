package contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * ContactServiceTest.java
 *
 * Author: Luis Tomassini
 * Course: CS 320 – Software Testing
 * Assignment: Contact Service
 *
 * Description:
 * Unit tests for the ContactService class. These tests validate
 * the functionality of adding, deleting, and updating contacts
 * within an in-memory data structure.
 *
 * The test suite ensures unique contact IDs are enforced and that
 * service operations behave correctly under both valid and invalid conditions.
 */

public class ContactServiceTest {

    private ContactService service;

    @BeforeEach
    void setup() {
        service = new ContactService();
    }

    @Test
    void testAddContact_success() {
        Contact c = new Contact("ID1", "Luis", "Tom", "1234567890", "123 Main St");
        service.addContact(c);
        assertNotNull(service.getContact("ID1"));
    }

    @Test
    void testAddContact_duplicateId_throws() {
        service.addContact(new Contact("ID1", "Luis", "Tom", "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () ->
                service.addContact(new Contact("ID1", "Jane", "Doe", "0987654321", "456 Oak Ave")));
    }

    @Test
    void testDeleteContact_success() {
        service.addContact(new Contact("ID1", "Luis", "Tom", "1234567890", "123 Main St"));
        service.deleteContact("ID1");
        assertThrows(IllegalArgumentException.class, () -> service.getContact("ID1"));
    }

    @Test
    void testDeleteContact_missingId_throws() {
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("MISSING"));
    }

    @Test
    void testUpdateFirstName_success() {
        service.addContact(new Contact("ID1", "Luis", "Tom", "1234567890", "123 Main St"));
        service.updateFirstName("ID1", "Lu");
        assertEquals("Lu", service.getContact("ID1").getFirstName());
    }

    @Test
    void testUpdateLastName_success() {
        service.addContact(new Contact("ID1", "Luis", "Tom", "1234567890", "123 Main St"));
        service.updateLastName("ID1", "T");
        assertEquals("T", service.getContact("ID1").getLastName());
    }

    @Test
    void testUpdatePhone_success() {
        service.addContact(new Contact("ID1", "Luis", "Tom", "1234567890", "123 Main St"));
        service.updatePhone("ID1", "0987654321");
        assertEquals("0987654321", service.getContact("ID1").getPhone());
    }

    @Test
    void testUpdateAddress_success() {
        service.addContact(new Contact("ID1", "Luis", "Tom", "1234567890", "123 Main St"));
        service.updateAddress("ID1", "456 Oak Ave");
        assertEquals("456 Oak Ave", service.getContact("ID1").getAddress());
    }

    @Test
    void testUpdateMissingContact_throws() {
        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("MISSING", "Lu"));
    }

    @Test
    void testUpdateWithInvalidValue_throws() {
        service.addContact(new Contact("ID1", "Luis", "Tom", "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> service.updatePhone("ID1", "123"));
    }
}
