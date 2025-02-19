class Item {
    String name;
    int id;
    int quantity;
    double price;
    Item next;

    public Item(String name, int id, int quantity, double price) {
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class Inventory {
    private Item head;

    public void addAtBeginning(String name, int id, int quantity, double price) {
        Item newItem = new Item(name, id, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    public void addAtEnd(String name, int id, int quantity, double price) {
        Item newItem = new Item(name, id, quantity, price);
        if (head == null) {
            head = newItem;
            return;
        }
        Item temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newItem;
    }

    public void addAtPosition(String name, int id, int quantity, double price, int position) {
        if (position <= 0) {
            addAtBeginning(name, id, quantity, price);
            return;
        }
        Item newItem = new Item(name, id, quantity, price);
        Item temp = head;
        for (int i = 1; temp != null && i < position; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            addAtEnd(name, id, quantity, price);
            return;
        }
        newItem.next = temp.next;
        temp.next = newItem;
    }

    public void removeById(int id) {
        if (head == null) return;
        if (head.id == id) {
            head = head.next;
            return;
        }
        Item temp = head;
        while (temp.next != null && temp.next.id != id) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    public void updateQuantity(int id, int quantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.id == id) {
                temp.quantity = quantity;
                return;
            }
            temp = temp.next;
        }
    }

    public void searchByIdOrName(int id, String name) {
        Item temp = head;
        while (temp != null) {
            if (temp.id == id || temp.name.equals(name)) {
                System.out.println("Item: " + temp.name + ", ID: " + temp.id + ", Quantity: " + temp.quantity + ", Price: " + temp.price);
            }
            temp = temp.next;
        }
    }

    public void displayTotalValue() {
        double totalValue = 0;
        Item temp = head;
        while (temp != null) {
            totalValue += temp.quantity * temp.price;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: " + totalValue);
    }

    public void sortByNameOrPrice(boolean sortByName, boolean ascending) {
        if (head == null || head.next == null) return;
        head = mergeSort(head, sortByName, ascending);
    }

    private Item mergeSort(Item head, boolean sortByName, boolean ascending) {
        if (head == null || head.next == null) return head;
        Item mid = getMiddle(head);
        Item nextToMid = mid.next;
        mid.next = null;
        Item left = mergeSort(head, sortByName, ascending);
        Item right = mergeSort(nextToMid, sortByName, ascending);
        return merge(left, right, sortByName, ascending);
    }

    private Item merge(Item left, Item right, boolean sortByName, boolean ascending) {
        if (left == null) return right;
        if (right == null) return left;
        boolean condition = sortByName ? left.name.compareTo(right.name) < 0 : left.price < right.price;
        if (!ascending) condition = !condition;
        if (condition) {
            left.next = merge(left.next, right, sortByName, ascending);
            return left;
        } else {
            right.next = merge(left, right.next, sortByName, ascending);
            return right;
        }
    }

    private Item getMiddle(Item head) {
        if (head == null) return head;
        Item slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void displayAll() {
        Item temp = head;
        while (temp != null) {
            System.out.println("Item: " + temp.name + ", ID: " + temp.id + ", Quantity: " + temp.quantity + ", Price: " + temp.price);
            temp = temp.next;
        }
    }
}

public class InventoryManagement {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.addAtEnd("Laptop", 101, 10, 800.0);
        inventory.addAtBeginning("Mouse", 102, 50, 25.0);
        inventory.addAtPosition("Keyboard", 103, 30, 45.0, 1);
        inventory.displayAll();
        inventory.updateQuantity(101, 12);
        inventory.displayTotalValue();
        inventory.sortByNameOrPrice(true, true);
        inventory.displayAll();
        inventory.removeById(102);
        inventory.displayAll();
    }
}