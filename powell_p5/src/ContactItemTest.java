import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ContactItemTest {

    @Test
    public void creationFailsWithAllBlankValues() {
        var contact = new ContactItem();
        assertEquals(false, contact.checkBlankContactItem(contact));
    }

    @Test
    public void creationSucceedsWithBlankEmail() {
        var contact = new ContactItem();
        assertEquals(true, contact.checkBlankEmail(contact));
    }

    @Test
    public void creationSucceedsWithBlankFirstName() {
        var contact = new ContactItem();
        assertEquals(true, contact.checkBlankFirstName(contact));
    }

    @Test
    public void creationSucceedsWithBlankLastName() {
        var contact = new ContactItem();
        assertEquals(true, contact.checkBlankLastName(contact));
    }

    @Test
    public void creationSucceedsWithBlankPhone() {
        var contact = new ContactItem();
        assertEquals(true, contact.checkBlankPhoneNumber(contact));
    }

    @Test
    public void creationSucceedsWithNonBlankValues() {
        var contact = new ContactItem();
        assertEquals(true, contact.checkNonBlankContact(contact));
    }

    @Test
    public void editingFailsWithAllBlankValues() {
        var contact = new ContactItem();
        assertEquals(false, contact.checkBlankContact(contact));
    }

    @Test
    public void editingSucceedsWithBlankEmail() {
        var contact = new ContactItem();
        assertEquals(true, contact.checkBlankEmail(contact));
    }

    @Test
    public void editingSucceedsWithBlankFirstName() {
        var contact = new ContactItem();
        assertEquals(true, contact.checkBlankFirstName(contact));
    }

    @Test
    public void editingSucceedsWithBlankLastName() {
        var contact = new ContactItem();
        assertEquals(true, contact.checkBlankLastName(contact));
    }

    @Test
    public void editingSucceedsWithBlankPhone() {
        var contact = new ContactItem();
        assertEquals(true, contact.checkBlankPhoneNumber(contact));
    }

    @Test
    public void editingSucceedsWithNonBlankValues() {
        var contact = new ContactItem();
        assertEquals(true, contact.checkNonBlankContact(contact));
    }



    //testToString()





}
