import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactApp {

    static ArrayList<ContactItem> ContactList = new ArrayList<>();

    public static void contactStartMenu() {
        try {
            System.out.println("Main Menu\n---------\n");
            System.out.println("1) create a new list");
            System.out.println("2) load an existing list");
            System.out.println("3) quit");

            Scanner scan = new Scanner(System.in);
            int start = scan.nextInt();

            if(start != 1 && start != 2 && start != 3)
                throw new Exception();

            contactStartMenuInput(start);
        }
        catch(Exception e) {
            System.out.println("Invalid entry, please try again.");
            contactStartMenu();
        }
    }

    public static void contactOperationMenu() {

        try{
            System.out.println("1) view the list");
            System.out.println("2) add an item");
            System.out.println("3) edit an item");
            System.out.println("4) remove an item");
            System.out.println("5) save the current list");
            System.out.println("6) quit to the main menu\n");

            Scanner scan = new Scanner(System.in);
            int operation = scan.nextInt();

            if(operation != 1 && operation != 2 && operation != 3 && operation != 4 && operation != 5 && operation != 6)
                throw new Exception();

            ContactList List = new ContactList();
            List.ContactListOperationMenuInput(operation);
        }
        catch(Exception e) {
            System.out.println("Invalid entry, please try again.");
            contactOperationMenu();
        }

    }

    public static void contactStartMenuInput(int select) {
        Scanner scan = new Scanner(System.in);
        if (select == 1) {
            System.out.println(">1\nnew contact list has been created\n");
            contactOperationMenu();
        }

        if (select == 2) {
            try {
                ContactList.clear();

                System.out.println(">2\nEnter the filename to load");
                String Load = scan.nextLine();
                Scanner scanner = new Scanner(new File(Load));
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    ContactItem contact = new ContactItem();

                    var lineData = line.split(",");
                    contact.firstName = lineData[0];
                    contact.lastName = lineData[1];
                    contact.phoneNumber = lineData[2];
                    contact.emailAddress = lineData[3];

                    ContactList.add(contact);
                }
                contactOperationMenu();
            } catch (Exception e) {
                System.out.println("Invalid file name, please try again.");
                contactStartMenuInput(2);
            }
        }

        if (select == 3) {
            StartHere.applicationMenu();
        }
    }

}
