class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskCircularLinkedList {
    private Task head = null;
    private Task tail = null;
    private Task currentTask = null;

    public void addAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            tail.next = head;
        } else {
            newTask.next = head;
            head = newTask;
            tail.next = head;
        }
    }

    public void addAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            tail.next = head;
        } else {
            tail.next = newTask;
            tail = newTask;
            tail.next = head;
        }
    }

    public void addAtPosition(int taskId, String taskName, int priority, String dueDate, int position) {
        if (position <= 0) {
            addAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        Task temp = head;
        for (int i = 1; temp.next != head && i < position; i++) {
            temp = temp.next;
        }
        newTask.next = temp.next;
        temp.next = newTask;
        if (temp == tail) {
            tail = newTask;
        }
    }

    public void removeByTaskId(int taskId) {
        if (head == null) return;
        Task temp = head, prev = tail;
        do {
            if (temp.taskId == taskId) {
                if (temp == head) head = head.next;
                if (temp == tail) tail = prev;
                prev.next = temp.next;
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    public void viewCurrentTask() {
        if (currentTask == null) currentTask = head;
        if (currentTask != null) {
            System.out.println("Task ID: " + currentTask.taskId + ", Name: " + currentTask.taskName + ", Priority: " + currentTask.priority + ", Due Date: " + currentTask.dueDate);
            currentTask = currentTask.next;
        }
    }

    public void displayAll() {
        if (head == null) return;
        Task temp = head;
        do {
            System.out.println("Task ID: " + temp.taskId + ", Name: " + temp.taskName + ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchByPriority(int priority) {
        if (head == null) return;
        Task temp = head;
        do {
            if (temp.priority == priority) {
                System.out.println("Task ID: " + temp.taskId + ", Name: " + temp.taskName + ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
            }
            temp = temp.next;
        } while (temp != head);
    }
}

public class TaskScheduler {
    public static void main(String[] args) {
        TaskCircularLinkedList scheduler = new TaskCircularLinkedList();
        scheduler.addAtEnd(1, "Task A", 2, "2024-02-20");
        scheduler.addAtBeginning(2, "Task B", 1, "2024-02-18");
        scheduler.addAtPosition(3, "Task C", 3, "2024-02-25", 1);
        scheduler.displayAll();
        scheduler.viewCurrentTask();
        scheduler.viewCurrentTask();
        scheduler.searchByPriority(1);
        scheduler.removeByTaskId(2);
        scheduler.displayAll();
    }
}
