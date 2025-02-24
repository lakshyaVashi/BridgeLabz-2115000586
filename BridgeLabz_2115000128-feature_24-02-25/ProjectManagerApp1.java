import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class ProjectManager {
    @Todo(task = "Implement authentication module", assignedTo = "Alice", priority = "HIGH")
    public void implementAuth() {
        System.out.println("Authentication module pending implementation.");
    }

    @Todo(task = "Optimize database queries", assignedTo = "Bob")
    public void optimizeDatabase() {
        System.out.println("Database optimization pending.");
    }

    @Todo(task = "Refactor legacy code", assignedTo = "Charlie", priority = "LOW")
    public void refactorCode() {
        System.out.println("Legacy code refactoring pending.");
    }

    public void completeDeployment() {
        System.out.println("Deployment completed.");
    }
}

public class ProjectManagerApp1 {
    public static void main(String[] args) {
        ProjectManager manager = new ProjectManager();
        manager.implementAuth();
        manager.optimizeDatabase();
        manager.refactorCode();
        manager.completeDeployment();

        try {
            Method[] methods = ProjectManager.class.getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(Todo.class)) {
                    Todo todo = method.getAnnotation(Todo.class);
                    System.out.println("Pending Task: " + todo.task());
                    System.out.println("Assigned To: " + todo.assignedTo());
                    System.out.println("Priority: " + todo.priority());
                    System.out.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}