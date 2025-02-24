import java.lang.reflect.*;

class Person {
    private int age;

    public Person(int age) {
        this.age = age;
    }
}

public class AccessPrivateFieldApp {
    public static void main(String[] args) {
        try {
            Person person = new Person(25);
            Field ageField = Person.class.getDeclaredField("age");
            ageField.setAccessible(true);
            System.out.println("Original age: " + ageField.get(person));
            ageField.set(person, 30);
            System.out.println("Modified age: " + ageField.get(person));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
