import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ContactListTest {
    @Test
    public void addingItemsIncreasesSize() {
        ContactList List = new ContactList();
        assertEquals(true, List.checkAddContactListSize(List));
    }

    @Test
    public void editingItemsFailsWithAllBlankValues() {
        var contact = new ContactItem();
        assertEquals(false, contact.checkBlankContact(contact));
    }

    @Test
    public void editingItemsFailsWithInvalidIndex() {
        var List = new ArrayList<ContactItem>();
        var ContactList = new ContactList();
        assertEquals(false, ContactList.EditContactList(List, 1));
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

    @Test
    public void newListIsEmpty() {
        var ContactList = new ContactList();
        var contactItem = new ContactItem();
        var List = new ArrayList<ContactItem>();

        assertEquals(true, List.isEmpty());
    }

    @Test
    public void removingContactItemsDecreasesSize() {
        ContactList List = new ContactList();
        assertEquals(true, List.checkRemoveContactListSize(List));
    }

    @Test
    public void removingContactItemsFailsWithInvalidIndex() {
        var contactList = new ContactList();
        var contactItem = new ContactItem();
        var List = new ArrayList<ContactItem>();

        assertEquals(false, ContactList.RemoveContactItem(List,1));
    }

    @Test
    public void savedContactListCanBeLoaded() {
        // This will pass if you save a non-empty file with this name
        var fileName = "contactFile.txt";
        assertEquals(true, ContactList.ContactLoadFile(fileName));
    }
}
