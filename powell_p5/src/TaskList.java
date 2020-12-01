import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskList extends TaskItem {

    public static TaskItem TaskCreationOrEdit(TaskItem Task) {
        Scanner scan = new Scanner(System.in);
        scan = new Scanner(System.in);

        System.out.println("Enter a new title for the task");
        Task.title = scan.nextLine();
        while (!checkTaskTitle(Task.title)) {
            System.out.println("Invalid title, please enter a title of at least one character");
            Task.title = scan.nextLine();
        }

        System.out.println("Enter a new description for the task");
        var description = scan.nextLine();
        EditDescription(Task, description);

        System.out.println("Enter a new task due date (YYYY-MM-DD)");
        var dueDate = scan.nextLine();
        EditDueDate(Task, dueDate);

        String tempDueDate = Task.dueDate;
        while (!checkTaskDueDate(Task.dueDate)) {
            System.out.println("Invalid due date, please enter the date in the format (YYYY-MM-DD)");
            Task.dueDate = scan.nextLine();
        }
        return Task;
    }

    public boolean checkTaskCompletion(ArrayList<TaskItem> List) {
        int i = 0;
        int count = 0;

        for(i = 0; i < List.size(); i++) {
            if(List.get(i).TaskCompleted) {
                count++;
            }
        }
        if(count == List.size()){
            return false;
        }
        return true;
    }

    public boolean checkTaskIncomplete(ArrayList<TaskItem> List) {
        int i = 0;
        int count = 0;

        for(i = 0; i < List.size(); i++) {
            if(!List.get(i).TaskCompleted) {
                count++;
            }
        }
        if(count == List.size()){
            return false;
        }
        return true;
    }

    public static boolean EditTask(ArrayList<TaskItem> Tasks, int index){
        try{
            var task = Tasks.get(index);
            task = TaskCreationOrEdit(task);
            return true;

        }catch(Exception e)
        {
            return false;
        }
    }

    public static boolean EditDescription(TaskItem Task, String Description){
        Task.description = Description;
        return true;
    }

    public static boolean EditDueDate(TaskItem Task, String DueDate){
        var success = checkTaskDueDate(DueDate);
        if(success)
            Task.dueDate = DueDate;

        return success;
    }

    public boolean GetItemDescription(ArrayList<TaskItem> List, int index) {

        try{
            var task = List.get(index).description;
        }
        catch(Exception e)
        {
            return false;
        }

        return true;
    }

    public boolean GetItemDueDate(ArrayList<TaskItem> List, int index) {

        try{
            var task = List.get(index).dueDate;
        }
        catch(Exception e)
        {
            return false;
        }

        return true;
    }

    public boolean GetItemTitle(ArrayList<TaskItem> List, int index) {

        try{
            var task = List.get(index).title;
        }
        catch(Exception e)
        {
            return false;
        }

        return true;
    }

    public boolean RemoveItem(ArrayList<TaskItem> List, int index)
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

    public static boolean LoadFile(String fileName)
    {
        try{
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                TaskItem task = new TaskItem();
                var List = new ArrayList<TaskItem>();

                var lineData = line.split(" ");
                task.dueDate = lineData[0];
                task.title = lineData[1];
                task.description = lineData[2];
                task.TaskCompleted = Boolean.parseBoolean(lineData[3]);

                List.add(task);
            }
        }
        catch(Exception e)
        {
            return false;
        }

        return true;
    }

    public static boolean EditTitle(TaskItem Task, String Title){
        var success = checkTaskTitle(Title);
        if(success)
            Task.title = Title;

        return success;
    }

    public boolean checkAddTaskListSize(TaskItem Task) {
        int tempSize = TaskList.size();

        Task = new TaskItem();

        TaskList.add(Task);

        if (tempSize != TaskList.size()) {
            return true;
        }
        return false;
    }

    public boolean checkRemoveTaskListSize(TaskItem Task) {
        int tempSize = TaskList.size();

        Task = new TaskItem();

        TaskList.add(Task);
        TaskList.remove(Task);

        if (tempSize == TaskList.size()) {
            return true;
        }
        return false;
    }

    public boolean markCompleteTaskItemStatus(TaskItem Task) {
        trueTaskCompletionStatus(Task);

        if (Task.TaskCompleted) {
            return true;
        }
        return false;
    }

    public boolean markCompleteTaskItemStatus(ArrayList<TaskItem> List, int index) {

        try{
            var task = List.get(index);
            task.TaskCompleted = true;
        }
        catch(Exception e)
        {
            return false;
        }

        return true;
    }


    public static boolean markIncompleteTaskItemStatus(ArrayList<TaskItem> TaskList, int indexToMark) {

        try{
            var Task = TaskList.get(indexToMark);
            falseTaskCompletionStatus(Task);

            if (!Task.TaskCompleted) {
                return true;
            }
        }
        catch(Exception e)
        {
            return false;
        }

        return true;
    }

    public static boolean markIncompleteTaskItemStatus(TaskItem Task) {
        falseTaskCompletionStatus(Task);

        if (!Task.TaskCompleted) {
            return true;
        }
        return false;
    }

    public static void falseTaskCompletionStatus(TaskItem Task) {
        Task.TaskCompleted = false;
    }

    public void trueTaskCompletionStatus(TaskItem Task) {
        Task.TaskCompleted = true;
    }

    public void ListOperationMenuInput(int select) {
        var Task = new TaskItem();
        Scanner scan = new Scanner(System.in);

        switch (select) {
            case 1:
                if(!TaskList.isEmpty()) {
                    System.out.println(">1\n\nCurrent Tasks\n---------");

                    TaskPrint(Task);

                    operationMenu();
                }

                System.out.println("Your task list is empty, there is nothing to view\n");
                operationMenu();
                break;
            case 2:

                System.out.println(">2\n");

                Task = new TaskItem();

                TaskCreationOrEdit(Task);

                TaskList.add(Task);

                operationMenu();

                break;
            case 3:
                scan = new Scanner(System.in);

                if(!TaskList.isEmpty()) {
                    System.out.println(">3\nCurrent Tasks\n---------\n");

                    TaskPrint(Task);

                    System.out.println("Which task would you like to edit? Enter a number\n");
                    int taskSelect = scan.nextInt();
                    Task = TaskList.get(taskSelect);

                    scan.nextLine();

                    TaskCreationOrEdit(Task);

                    operationMenu();
                }

                System.out.println("Your task list is empty, there is nothing to edit\n");
                operationMenu();
                break;
            case 4:
                scan = new Scanner(System.in);

                if(!TaskList.isEmpty()) {
                    System.out.println(">4\nCurrent Tasks\n---------\n");

                    TaskPrint(Task);

                    System.out.println("Which task will you remove?\n");

                    int removeTask = scan.nextInt();

                    try {
                        TaskList.remove(removeTask);
                    } catch (Exception e) {
                        System.out.println("Invalid entry, no task was removed");
                    }

                    operationMenu();
                }

                System.out.println("Your task list is empty, there is nothing to remove\n");
                operationMenu();
                break;
            case 5:
                int markedComplete;

                if(!TaskList.isEmpty()) {
                    if (checkTaskCompletion(TaskList)) {
                        System.out.println(">5\nWhich task will you mark as completed?\n\n");

                        for (int i = 0; i < TaskList.size(); i++) {
                            Task = TaskList.get(i);
                            if (!Task.TaskCompleted) {
                                System.out.print(i + ") ");
                                System.out.print("[" + Task.dueDate + "]");
                                System.out.print(Task.title + ": ");
                                System.out.print(Task.description);
                                System.out.println();
                            }
                            System.out.println();
                        }
                        try {
                            scan = new Scanner(System.in);
                            markedComplete = scan.nextInt();
                            Task = TaskList.get(markedComplete);
                            trueTaskCompletionStatus(Task);
                        } catch (Exception e) {
                            System.out.println("Invalid entry, no task selected\n");
                        }
                    } else {
                        System.out.println("All tasks are marked as complete, there is nothing to mark\n");
                    }
                    operationMenu();
                }

                System.out.println("Your task list is empty, there is nothing to mark as complete\n");
                operationMenu();
                break;
            case 6:
                int unmarkedComplete;

                if(!TaskList.isEmpty()) {
                    if (checkTaskIncomplete(TaskList)) {
                        System.out.println(">6\nWhich task will you un-mark as completed?\n\n");
                        for (int i = 0; i < TaskList.size(); i++) {
                            Task = TaskList.get(i);
                            if (Task.TaskCompleted) {
                                System.out.print(i + ") ");
                                System.out.print("[" + Task.dueDate + "]");
                                System.out.print(Task.title + ": ");
                                System.out.print(Task.description);
                                System.out.println();
                            }
                        }
                        try {
                            scan = new Scanner(System.in);
                            unmarkedComplete = scan.nextInt();
                            Task = TaskList.get(unmarkedComplete);
                            Task.TaskCompleted = false;
                        } catch (Exception e) {
                            System.out.println("Invalid entry, no task selected\n");
                        }
                        operationMenu();
                    } else {
                        System.out.println("All tasks are marked as incomplete, there is nothing to mark\n");
                    }
                    operationMenu();
                }

                System.out.println("Your task list is empty, there is nothing to mark as incomplete\n");
                operationMenu();
                break;
            case 7:
                if(!TaskList.isEmpty()) {
                    try {
                        scan = new Scanner(System.in);
                        System.out.println(">7\nEnter the filename to save as:");
                        String Create = scan.nextLine();
                        File fileName = new File(Create);

                        var writer = new FileWriter(Create);

                        for (TaskItem item : TaskList) {
                            Task = item;
                            writer.write(Task.dueDate + " " + Task.title + " " +
                                    Task.description + " " + Task.TaskCompleted);
                            writer.write("\n");
                        }

                        writer.close();

                        System.out.println("task list has been saved");

                        operationMenu();
                        break;
                    } catch (Exception e) {
                    }
                }

                System.out.println("Your task list is empty, there is nothing to save\n");
                operationMenu();
                break;
            case 8:
                startMenu();
                break;
            default:
                System.out.print("Invalid selection");
                operationMenu();
                break;
        }
    }
}
