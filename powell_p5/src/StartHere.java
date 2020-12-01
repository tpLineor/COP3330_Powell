import java.io.File;
import java.util.Scanner;

public class StartHere {

    public static void main(String[] args) {
        applicationMenu();
    }

    public static void applicationMenu() {
        int application = 0;

        while (application != 1 && application != 2 && application != 3) {
            System.out.println("Select your application\n---------\n");
            System.out.println("1) Task List");
            System.out.println("2) Contact List");
            System.out.println("3) quit");

            Scanner scan = new Scanner(System.in);
            application = scan.nextInt();
        }

        applicationMenuInput(application);
    }

    public static void applicationMenuInput(int select) {
        Scanner scan = new Scanner(System.in);

        if (select == 1) {
            TaskApp.startMenu();
        }

        if (select == 2) {
            ContactApp.contactStartMenu();
        }

        if (select == 3) {
            System.exit(0);
        }
    }
}
