class Process {
    int processId;
    int burstTime;
    int priority;
    Process next;

    public Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private Process head;
    private Process tail;
    private int timeQuantum;

    public RoundRobinScheduler(int timeQuantum) {
        this.head = null;
        this.tail = null;
        this.timeQuantum = timeQuantum;
    }

    public void addProcess(int processId, int burstTime, int priority) {
        Process newProcess = new Process(processId, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            tail.next = head;
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head;
        }
    }

    public void executeProcesses() {
        if (head == null) return;
        Process current = head;
        int totalTime = 0, totalWaitingTime = 0, totalTurnaroundTime = 0, processCount = 0;
        
        while (head != null) {
            if (current.burstTime > timeQuantum) {
                totalTime += timeQuantum;
                current.burstTime -= timeQuantum;
                current = current.next;
            } else {
                totalTime += current.burstTime;
                totalTurnaroundTime += totalTime;
                totalWaitingTime += (totalTime - current.burstTime);
                removeProcess(current.processId);
                current = head;
            }
            displayProcesses();
        }
        
        System.out.println("Average Waiting Time: " + (double) totalWaitingTime / processCount);
        System.out.println("Average Turnaround Time: " + (double) totalTurnaroundTime / processCount);
    }

    private void removeProcess(int processId) {
        if (head == null) return;
        Process current = head, prev = null;
        do {
            if (current.processId == processId) {
                if (current == head) head = head.next;
                if (current == tail) tail = prev;
                if (prev != null) prev.next = current.next;
                if (head == tail && head.processId == processId) head = tail = null;
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
    }

    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes remaining.");
            return;
        }
        Process temp = head;
        do {
            System.out.println("Process ID: " + temp.processId + ", Burst Time: " + temp.burstTime + ", Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }
}

public class RoundRobinScheduling {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler(3);
        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 4, 2);
        scheduler.addProcess(3, 6, 1);
        scheduler.displayProcesses();
        scheduler.executeProcesses();
    }
}
