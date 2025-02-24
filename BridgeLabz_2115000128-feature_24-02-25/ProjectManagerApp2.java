import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface LogExecutionTime {}

class ProjectManager {
    @LogExecutionTime
    public void implementAuth() {
        long startTime = System.nanoTime();
        System.out.println("Implementing authentication module...");
        try {
            Thread.sleep(500); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        long endTime = System.nanoTime();
        System.out.println("Execution time for implementAuth: " + (endTime - startTime) + " ns\n");
    }

    @LogExecutionTime
    public void optimizeDatabase() {
        long startTime = System.nanoTime();
        System.out.println("Optimizing database queries...");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        long endTime = System.nanoTime();
        System.out.println("Execution time for optimizeDatabase: " + (endTime - startTime) + " ns\n");
    }

    @LogExecutionTime
    public void refactorCode() {
        long startTime = System.nanoTime();
        System.out.println("Refactoring legacy code...");
        try {
            Thread.sleep(700); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        long endTime = System.nanoTime();
        System.out.println("Execution time for refactorCode: " + (endTime - startTime) + " ns\n");
    }

    public void completeDeployment() {
        System.out.println("Deployment completed.");
    }
}

public class ProjectManagerApp2 {
    public static void main(String[] args) {
        ProjectManager manager = new ProjectManager();
        
        try {
            Method[] methods = ProjectManager.class.getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(LogExecutionTime.class)) {
                    long startTime = System.nanoTime();
                    method.invoke(manager);
                    long endTime = System.nanoTime();
                    System.out.println("[Reflection] Execution time for " + method.getName() + ": " + (endTime - startTime) + " ns\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
