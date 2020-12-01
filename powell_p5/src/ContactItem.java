import java.util.ArrayList;

public class ContactItem extends ContactApp {

    String firstName;
    String lastName;
    String phoneNumber;
    String emailAddress;

    public void ContactPrint(ArrayList<ContactItem> List) {
        for (int i = 0; i < List.size(); i++) {
            ContactItem contact = List.get(i);
            System.out.print(i + ")\n");
            System.out.print("First name: " + contact.firstName + "\n");
            System.out.print("Last name: " + contact.lastName + "\n");
            System.out.print("Phone number (xxx-xxx-xxxx): " + contact.phoneNumber + "\n");
            System.out.print("Email address (x@y.z): " + contact.emailAddress + "\n");
            System.out.println();
        }
    }

    public static boolean checkBlankContactItem(ContactItem contact) {
        var list = new ContactList();

        contact.firstName = "";
        contact.lastName = "";
        contact.phoneNumber = "";
        contact.emailAddress = "";

        if(!list.ContactValidationNull(contact)) {
            return false;
        }
            return true;
    }

    public static boolean checkBlankFirstName(ContactItem contact) {
        var list = new ContactList();
        contact.firstName = "";
        contact.lastName = "Doe";
        contact.phoneNumber = "123-456-7890";
        contact.emailAddress = "johndoe@xyz.com";

        if(!list.ContactValidationNull(contact)) {
            return false;
        }
        return true;
    }

    public static boolean checkBlankLastName(ContactItem contact) {
        var list = new ContactList();
        contact.firstName = "John";
        contact.lastName = "";
        contact.phoneNumber = "123-456-7890";
        contact.emailAddress = "johndoe@xyz.com";

        if(!list.ContactValidationNull(contact)) {
            return false;
        }
        return true;
    }

    public static boolean checkBlankPhoneNumber(ContactItem contact) {
        var list = new ContactList();
        contact.firstName = "John";
        contact.lastName = "Doe";
        contact.phoneNumber = "";
        contact.emailAddress = "johndoe@xyz.com";

        if(!list.ContactValidationNull(contact)) {
            return false;
        }
        return true;
    }

    public static boolean checkBlankEmail(ContactItem contact) {
        var list = new ContactList();
        contact.firstName = "John";
        contact.lastName = "Doe";
        contact.phoneNumber = "123-456-7890";
        contact.emailAddress = "";

        if(!list.ContactValidationNull(contact)) {
            return false;
        }
        return true;
    }

    public static boolean checkNonBlankContact(ContactItem contact) {
        var list = new ContactList();
        contact.firstName = "John";
        contact.lastName = "Doe";
        contact.phoneNumber = "123-456-7890";
        contact.emailAddress = "johndoe@xyz.com";

        if(!list.ContactValidationNull(contact)) {
            return false;
        }
        return true;
    }

    public static boolean checkBlankContact(ContactItem contact) {
        var list = new ContactList();
        contact.firstName = "";
        contact.lastName = "";
        contact.phoneNumber = "";
        contact.emailAddress = "";

        if(!list.ContactValidationNull(contact)) {
            return false;
        }
        return true;
    }


}
