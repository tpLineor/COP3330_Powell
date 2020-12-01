import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {
    @Test
    public void addingTaskItemsIncreasesSize() {
        TaskList List = new TaskList();
        assertEquals(true, List.checkAddTaskListSize(List));
    }

    @Test
    public void removingTaskItemsDecreasesSize() {
        TaskList List = new TaskList();
        assertEquals(true, List.checkRemoveTaskListSize(List));
    }

    @Test
    public void completingTaskItemChangesStatus() {
        TaskList List = new TaskList();
        assertEquals(true, List.markCompleteTaskItemStatus(List));
    }

    @Test
    public void uncompletingTaskItemChangesStatus() {
        TaskList List = new TaskList();
        assertEquals(true, List.markIncompleteTaskItemStatus(List));
    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex() {
        var List = new ArrayList<TaskItem>();
        var TaskList = new TaskList();
        assertEquals(false, TaskList.markCompleteTaskItemStatus(List, 1));
    }

    @Test
    public void editingTaskItemFailsWithInvalidIndex() {
        var List = new ArrayList<TaskItem>();
        var TaskList = new TaskList();
        assertEquals(false, TaskList.EditTask(List, 1));
    }

    @Test
    public void editingItemDescriptionSucceedsWithExpectedValue() {
        var List = new TaskList();
        var Task = new TaskItem();

        assertEquals(true, List.EditDescription(Task, "Expected Value"));
    }

    @Test
    public void editingItemDueDateSucceedsWithExpectedValue() {
        var List = new TaskList();
        var Task = new TaskItem();

        assertEquals(true, List.EditDueDate(Task, "2020-11-27"));
    }

    @Test
    public void editingItemTitleFailsWithEmptyString() {
        var List = new TaskList();
        var Task = new TaskItem();

        assertEquals(false, List.EditTitle(Task, ""));
    }

    @Test
    public void editingItemTitleFailsWithInvalidIndex() {
        var TaskList = new TaskList();
        var Task = new TaskItem();
        var List = new ArrayList<TaskItem>();

        assertEquals(false, TaskList.EditTask(List, 1));
    }

    @Test
    public void editingItemTitleSucceedsWithExpectedValue() {
        var List = new TaskList();
        var Task = new TaskItem();

        assertEquals(true, List.EditTitle(Task, "Expected Value"));
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidDateFormat() {
        var List = new TaskList();
        var Task = new TaskItem();

        assertEquals(false, List.EditDueDate(Task, "21505-11-27"));
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex() {
        var TaskList = new TaskList();
        var Task = new TaskItem();
        var List = new ArrayList<TaskItem>();

        assertEquals(false, TaskList.EditTask(List, 1));
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidYYYMMDD() {
        TaskItem Task = new TaskItem();
        assertEquals(false, TaskList.EditDueDate(Task,"YYYMMDD Test"));
    }

    @Test
    public void gettingItemDescriptionFailsWithInvalidIndex() {
        var TaskList = new TaskList();
        var Task = new TaskItem();
        var List = new ArrayList<TaskItem>();

        assertEquals(false, TaskList.GetItemDescription(List,1));
    }

    @Test
    public void gettingItemDescriptionSucceedsWithValidIndex() {
        var TaskList = new TaskList();
        var Task = new TaskItem();
        var List = new ArrayList<TaskItem>();

        Task.description = "Test";
        List.add(Task);

        assertEquals(true, TaskList.GetItemDescription(List,0));
    }

    @Test
    public void gettingItemDueDateFailsWithInvalidIndex() {
        var TaskList = new TaskList();
        var Task = new TaskItem();
        var List = new ArrayList<TaskItem>();

        assertEquals(false, TaskList.GetItemDueDate(List,1));
    }

    @Test
    public void gettingItemDueDateSucceedsWithValidIndex() {
        var TaskList = new TaskList();
        var Task = new TaskItem();
        var List = new ArrayList<TaskItem>();

        Task.dueDate = "2020-11-27";
        List.add(Task);

        assertEquals(true, TaskList.GetItemDueDate(List,0));
    }

    @Test
    public void gettingItemTitleFailsWithInvalidIndex() {
        var TaskList = new TaskList();
        var Task = new TaskItem();
        var List = new ArrayList<TaskItem>();

        assertEquals(false, TaskList.GetItemTitle(List,1));
    }

    @Test
    public void gettingItemTitleSucceedsWithValidIndex() {
        var TaskList = new TaskList();
        var Task = new TaskItem();
        var List = new ArrayList<TaskItem>();

        Task.title = "Test Title";
        List.add(Task);

        assertEquals(true, TaskList.GetItemTitle(List,0));
    }

    @Test
    public void newListIsEmpty() {
        var TaskList = new TaskList();
        var Task = new TaskItem();
        var List = new ArrayList<TaskItem>();

        assertEquals(true, List.isEmpty());
    }

    @Test
    public void removingItemsFailsWithInvalidIndex() {
        var TaskList = new TaskList();
        var Task = new TaskItem();
        var List = new ArrayList<TaskItem>();

        assertEquals(false, TaskList.RemoveItem(List,1));
    }

    @Test
    public void savedTaskListCanBeLoaded() {
        // This will pass if you save a non-empty file with this name
        var fileName = "taskFile.txt";
        assertEquals(true, TaskList.LoadFile(fileName));
    }

    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex() {
        var List = new ArrayList<TaskItem>();
        var TaskList = new TaskList();
        var Task = new TaskItem();
        Task.TaskCompleted = true;

        List.add(Task);
        assertEquals(false, TaskList.markIncompleteTaskItemStatus(List, 1));
    }
}