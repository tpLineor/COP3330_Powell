import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {


    @Test
    public void constructorFailsWithInvalidDueDate() {
        TaskItem Task = new TaskItem();
        assertEquals(false, Task.checkTaskDueDate("202-12-24"));
    }

    @Test
    public void constructorFailsWithInvalidTitle() {
        TaskItem Task = new TaskItem();
        assertEquals(false, Task.checkTaskTitle("  "));
    }

    @Test
    public void constructorSucceedsWithValidDueDate() {
        TaskItem Task = new TaskItem();
        assertEquals(true, Task.checkTaskDueDate("2020-12-24"));
    }

    @Test
    public void constructorSucceedsWithValidTitle() {
        TaskItem Task = new TaskItem();
        assertEquals(true, Task.checkTaskTitle("Creating Title Test"));
    }

    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate() {
        TaskItem Task = new TaskItem();
        assertEquals(false, Task.checkTaskDueDate("202-12-24"));
    }

    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate() {
        TaskItem Task = new TaskItem();
        assertEquals(true, Task.checkTaskDueDate("2020-12-24"));
    }

    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle() {
        TaskItem Task = new TaskItem();
        assertEquals(false, Task.checkTaskTitle("  "));
    }

    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle() {
        TaskItem Task = new TaskItem();
        assertEquals(true, Task.checkTaskTitle("Editing Title Test"));
    }

    @Test
    public void editingDescriptionSucceedsWithExpectedValue() {
        TaskItem Task = new TaskItem();
        assertEquals(true, TaskList.EditDescription(Task, "Edit Desc Test"));
    }

    @Test
    public void editingDueDateFailsWithInvalidDateFormat() {
        TaskItem Task = new TaskItem();
        assertEquals(false, TaskList.EditDueDate(Task,"12343423"));
    }

    @Test
    public void editingDueDateFailsWithInvalidYYYMMDD() {
        TaskItem Task = new TaskItem();
        assertEquals(false, TaskList.EditDueDate(Task,"YYYMMDD Test"));
    }

    @Test
    public void editingDueDateSucceedsWithExpectedValue() {
        TaskItem Task = new TaskItem();
        assertEquals(true, TaskList.EditDueDate(Task, LocalDate.now().toString()));
    }

    @Test
    public void editingTitleFailsWithEmptyString() {
        TaskItem Task = new TaskItem();
        assertEquals(false, TaskList.EditTitle(Task,""));
    }

    @Test
    public void editingTitleSucceedsWithExpectedValue() {
        TaskItem Task = new TaskItem();
        assertEquals(true, TaskList.EditTitle(Task, "Expected Value"));
    }
}
