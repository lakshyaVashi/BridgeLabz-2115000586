import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Author {
    String name();
}

@Author(name = "John Doe")
class TaskManager {
    public void executeTask() {
        System.out.println("Executing task...");
    }
}

public class RetrieveAnnotationApp {
    public static void main(String[] args) {
        Class<TaskManager> clazz = TaskManager.class;
        if (clazz.isAnnotationPresent(Author.class)) {
            Author author = clazz.getAnnotation(Author.class);
            System.out.println("Author: " + author.name());
        } else {
            System.out.println("No Author annotation present.");
        }
    }
}