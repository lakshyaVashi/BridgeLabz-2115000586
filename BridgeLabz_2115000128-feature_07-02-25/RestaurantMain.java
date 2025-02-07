class Person1 {
    protected String name;
    protected int id;

    public Person1(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void displayInfo() {
        System.out.println("Name: " + name + ", ID: " + id);
    }
}

interface Worker {
    void performDuties();
}

class Chef extends Person1 implements Worker {
    private String specialty;

    public Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    public void displayRole() {
        System.out.println("Role: Chef, Specialty: " + specialty);
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is cooking gourmet dishes.");
    }
}

class Waiter extends Person1 implements Worker {
    private int experience;

    public Waiter(String name, int id, int experience) {
        super(name, id);
        this.experience = experience;
    }

    public void displayRole() {
        System.out.println("Role: Waiter, Experience: " + experience + " years");
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is serving customers.");
    }
}

public class RestaurantMain {
    public static void main(String[] args) {
        Chef chef = new Chef("Alice", 101, "Italian Cuisine");
        Waiter waiter = new Waiter("Bob", 102, 5);

        chef.displayInfo();
        chef.displayRole();
        chef.performDuties();
        System.out.println();

        waiter.displayInfo();
        waiter.displayRole();
        waiter.performDuties();
    }
}