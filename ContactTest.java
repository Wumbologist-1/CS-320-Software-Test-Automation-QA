package contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * ContactTest.java
 *
 * Author: Luis Tomassini
 * Course: CS 320 – Software Testing
 * Assignment: Contact Service
 *
 * Description:
 * Unit tests for the Contact class. These tests verify that all
 * validation rules are properly enforced, including constraints on
 * contact ID, first name, last name, phone number, and address.
 *
 * The tests ensure that valid objects are created successfully and
 * that invalid inputs correctly throw IllegalArgumentException.
 */

public class ContactTest {

    @Test
    void testValidContactCreation() {
        Contact c = new Contact("ID1", "Luis", "Tom", "1234567890", "123 Main St");
        assertEquals("ID1", c.getContactId());
        assertEquals("Luis", c.getFirstName());
        assertEquals("Tom", c.getLastName());
        assertEquals("1234567890", c.getPhone());
        assertEquals("123 Main St", c.getAddress());
    }

    @Test
    void testContactIdNull_throws() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact(null, "Luis", "Tom", "1234567890", "123 Main St"));
    }

    @Test
    void testContactIdTooLong_throws() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345678901", "Luis", "Tom", "1234567890", "123 Main St"));
    }

    @Test
    void testFirstNameNull_throws() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("ID1", null, "Tom", "1234567890", "123 Main St"));
    }

    @Test
    void testFirstNameTooLong_throws() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("ID1", "ThisIsTooLong", "Tom", "1234567890", "123 Main St"));
    }

    @Test
    void testLastNameNull_throws() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("ID1", "Luis", null, "1234567890", "123 Main St"));
    }

    @Test
    void testLastNameTooLong_throws() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("ID1", "Luis", "ThisIsTooLong", "1234567890", "123 Main St"));
    }

    @Test
    void testPhoneNull_throws() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("ID1", "Luis", "Tom", null, "123 Main St"));
    }

    @Test
    void testPhoneNot10Digits_throws() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("ID1", "Luis", "Tom", "12345", "123 Main St"));
    }

    @Test
    void testPhoneHasNonDigits_throws() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("ID1", "Luis", "Tom", "12345ABCDE", "123 Main St"));
    }

    @Test
    void testAddressNull_throws() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("ID1", "Luis", "Tom", "1234567890", null));
    }

    @Test
    void testAddressTooLong_throws() {
        String longAddress = "1234567890123456789012345678901"; // 31 chars
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("ID1", "Luis", "Tom", "1234567890", longAddress));
    }

    @Test
    void testSettersValidateFields() {
        Contact c = new Contact("ID1", "Luis", "Tom", "1234567890", "123 Main St");

        assertThrows(IllegalArgumentException.class, () -> c.setFirstName("ThisIsTooLong"));
        assertThrows(IllegalArgumentException.class, () -> c.setLastName("ThisIsTooLong"));
        assertThrows(IllegalArgumentException.class, () -> c.setPhone("999"));
        assertThrows(IllegalArgumentException.class, () -> c.setAddress("1234567890123456789012345678901"));
    }
}
