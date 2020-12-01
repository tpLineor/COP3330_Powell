import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskApp {

    static ArrayList<TaskItem> TaskList = new ArrayList<>();

    public static void startMenu() {

        try{
            System.out.println("Main Menu\n---------\n");
            System.out.println("1) create a new list");
            System.out.println("2) load an existing list");
            System.out.println("3) quit");

            Scanner scan = new Scanner(System.in);
            int start = scan.nextInt();

            if(start != 1 && start != 2 && start != 3)
                throw new Exception();

            StartMenuInput(start);

        } catch(Exception e) {
            System.out.println("Invalid entry, please try again.");
            startMenu();
        }

    }

    public static void operationMenu() {
        try {
            System.out.println("1) view the list");
            System.out.println("2) add an item");
            System.out.println("3) edit an item");
            System.out.println("4) remove an item");
            System.out.println("5) mark an item as completed");
            System.out.println("6) un-mark an item as completed");
            System.out.println("7) save the current list");
            System.out.println("8) quit to the main menu\n");

            Scanner scan = new Scanner(System.in);
            int operation = scan.nextInt();

            if(operation < 0 || operation > 8)
                throw new Exception();

            TaskList List = new TaskList();
            List.ListOperationMenuInput(operation);
        }catch(Exception e){
            System.out.println("Invalid entry, please try again.");
            operationMenu();
        }

    }

    public static void StartMenuInput(int select) {
        Scanner scan = new Scanner(System.in);
        if (select == 1) {
            System.out.println(">1\nnew task list has been created\n");
            operationMenu();
        }

        if (select == 2) {
            try {
                TaskList.clear();

                System.out.println(">2\nEnter the filename to load");
                String Load = scan.nextLine();
                Scanner scanner = new Scanner(new File(Load));
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    TaskItem task = new TaskItem();

                    var lineData = line.split(" ");
                    task.dueDate = lineData[0];
                    task.title = lineData[1];
                    task.description = lineData[2];
                    task.TaskCompleted = Boolean.parseBoolean(lineData[3]);

                    TaskList.add(task);
                }
                operationMenu();
            } catch (Exception e) {
            }
        }

        if (select == 3) {
            StartHere.applicationMenu();
        }
    }
}
