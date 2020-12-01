import javax.print.attribute.standard.NumberUp;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactList extends ContactItem {

    public static ContactItem ContactCreationOrEdit(ContactItem contactItem) {
        Scanner scan = new Scanner(System.in);
        scan = new Scanner(System.in);

        System.out.println("Enter a new first name for the contact\n");
        contactItem.firstName = scan.nextLine();

        System.out.println("Enter a new last name for the contact\n");
        contactItem.lastName = scan.nextLine();

        System.out.println("Enter a new phone number (xxx-xxx-xxxx)\n");
        contactItem.phoneNumber = scan.nextLine();

        while(!contactItem.phoneNumber.isEmpty() && !contactItem.phoneNumber.matches("(?:\\d{3}-){2}\\d{4}"))
        {
            System.out.println("Invalid phone number, please enter the number in the format (xxx-xxx-xxxx)");
            contactItem.phoneNumber = scan.nextLine();
        }

        System.out.println("Enter a new email address x@y.z\n");
        contactItem.emailAddress = scan.nextLine();

        while(!contactItem.emailAddress.isEmpty() && !contactItem.emailAddress.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$"))
        {
            System.out.println("Invalid email address, please enter the number in the format (x@y.z)");
            contactItem.emailAddress = scan.nextLine();
        }

        ContactValidationNull(contactItem);

        if(ContactValidationNull(contactItem) == false) {
            System.out.println("Invalid entry, at least one field must contain a value\n");
            ContactCreationOrEdit(contactItem);
        }

        return contactItem;
    }

    public boolean checkRemoveContactListSize(ContactItem contactItem) {
        int tempSize = ContactList.size();

        contactItem = new ContactItem();

        ContactList.add(contactItem);
        ContactList.remove(contactItem);

        if (tempSize == ContactList.size()) {
            return true;
        }
        return false;
    }

    public static boolean EditContactList(ArrayList<ContactItem> Tasks, int index) {
        try {
            var task = Tasks.get(index);
            task = ContactCreationOrEdit(task);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public static boolean RemoveContactItem(ArrayList<ContactItem> List, int index)
    {
        try{
            List.remove(index);
        }
        catch(Exception e)
        {
            return false;
        }

        return true;
    }

    public boolean checkAddContactListSize(ContactItem contactItem) {
        int tempSize = ContactList.size();

        contactItem = new ContactItem();

        ContactList.add(contactItem);

        if (tempSize != ContactList.size()) {
            return true;
        }
        return false;
    }

    public static boolean ContactLoadFile(String fileName)
    {
        try{
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                ContactItem contactItem = new ContactItem();
                var List = new ArrayList<ContactItem>();

                var lineData = line.split(" ");
                contactItem.firstName = lineData[0];
                contactItem.lastName = lineData[1];
                contactItem.phoneNumber = lineData[2];
                contactItem.emailAddress = lineData[3];

                List.add(contactItem);
            }
        }
        catch(Exception e)
        {
            return false;
        }

        return true;
    }

    public static boolean ContactValidationNull(ContactItem contactItem) {
        boolean firstName = true;
        boolean lastName = true;
        boolean phoneNumber = true;
        boolean email = true;

        if (contactItem.firstName == null || contactItem.firstName.isEmpty()) {
            firstName = false;
        }
        if (contactItem.lastName == null || contactItem.lastName.isEmpty()) {
            lastName = false;
        }
        if (contactItem.phoneNumber == null || contactItem.phoneNumber.isEmpty()) {
            phoneNumber = false;
        }
        if (contactItem.emailAddress == null || contactItem.emailAddress.isEmpty()) {
            email = false;
        }

        if (!firstName && !lastName && !phoneNumber && !email) {
            return false;
        }

        return true;
    }

    public void ContactListOperationMenuInput(int select) {
        var contact = new ContactItem();
        Scanner scan = new Scanner(System.in);

        switch (select) {
            case 1:
                if(!ContactList.isEmpty()) {
                    System.out.println(">1\n\nCurrent Contacts\n---------");

                    ContactPrint(ContactList);

                    contactOperationMenu();
                }

                System.out.println("\nYour contact list is empty, there is nothing to view\n");
                contactOperationMenu();
                break;
            case 2:

                System.out.println(">2\n");

                contact = ContactCreationOrEdit(contact);

                ContactList.add(contact);

                contactOperationMenu();

                break;

            case 3:
                scan = new Scanner(System.in);

                if(!ContactList.isEmpty()) {
                    System.out.println(">3\nCurrent Contacts\n---------\n");

                    ContactPrint(ContactList);

                    System.out.println("Which contact would you like to edit? Enter a number\n");
                    int contactSelect = scan.nextInt();

                    ContactItem contactItem = ContactList.get(contactSelect);

                    scan.nextLine();

                    ContactCreationOrEdit(contactItem);

                    contactOperationMenu();
                }

                System.out.println("\nYour contact list is empty, there is nothing to edit\n");
                contactOperationMenu();
                break;
            case 4:
                scan = new Scanner(System.in);

                if(!ContactList.isEmpty()) {
                    System.out.println(">4\nWhich contact will you remove?\n");

                    ContactPrint(ContactList);

                    int removeContact = scan.nextInt();

                    try {
                        ContactList.remove(removeContact);
                    } catch (Exception e) {
                        System.out.println("Invalid entry, no contact was removed\n");
                        ContactListOperationMenuInput(4);
                    }

                    contactOperationMenu();
                }

                System.out.println("\nYour contact list is empty, there is nothing to remove\n");
                contactOperationMenu();
                break;
            case 5:
                if(!ContactList.isEmpty()) {
                    try {
                        scan = new Scanner(System.in);
                        System.out.println(">5\nEnter the filename to save as:\n");
                        String Create = scan.nextLine();
                        File fileName = new File(Create);

                        var writer = new FileWriter(Create);

                        for (var contactListItem : ContactList) {
                            writer.write(
                                    contactListItem.firstName + " ,"
                                            + contactListItem.lastName + " ,"
                                            + contactListItem.phoneNumber + " ,"
                                            + (!contactListItem.emailAddress.isEmpty() ? contactListItem.emailAddress : " "));

                            writer.write("\n");
                        }

                        writer.close();

                        System.out.println("contact list has been saved");

                        contactOperationMenu();
                        break;
                    } catch (Exception e) {
                        ContactListOperationMenuInput(5);
                    }
                }
                System.out.println("\nYour contact list is empty, there is nothing to save\n");
                contactOperationMenu();
                break;
            case 6:
                contactStartMenu();
                break;

            default:
                System.out.print("Invalid selection");
                contactOperationMenu();
                break;
        }
    }
}
