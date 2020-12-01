import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

public class TaskItem extends TaskApp {

    String dueDate;
    String title;
    String description;
    boolean TaskCompleted;

    Scanner scan = new Scanner(System.in);
    static ArrayList<TaskItem> TaskList = new ArrayList<>();

    public void TaskPrint(TaskItem Task) {
        for (int i = 0; i < TaskList.size(); i++) {
            Task = TaskList.get(i);
            System.out.print(i + ")");
            System.out.print("[" + Task.dueDate + "] ");
            System.out.print(Task.title + ": ");
            System.out.print(Task.description);
            System.out.println();
        }
        System.out.println();
    }

    public static boolean checkTaskTitle(String tempTitle) {

        if (tempTitle != null && tempTitle.trim().isEmpty()) {
            return false;
        } else
            return true;
    }

    public static boolean checkTaskDueDate(String tempDueDate) {

        try {
            LocalDate dateConversion = LocalDate.parse(tempDueDate);
            dateConversion.equals(tempDueDate);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
