import java.lang.reflect.*;

class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "'}";
    }
}

public class DynamicObjectCreationApp {
    public static void main(String[] args) {
        try {
            Class<Student> studentClass = Student.class;
            Constructor<Student> constructor = studentClass.getDeclaredConstructor(String.class);
            Student student = constructor.newInstance("Alice");
            System.out.println("Dynamically created student: " + student);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}