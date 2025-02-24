import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface ImportantMethod {
    String level() default "HIGH";
}

class ProjectManager {
    @ImportantMethod(level = "HIGH")
    public void processProject() {
        System.out.println("Processing project.");
    }

    @ImportantMethod(level = "MEDIUM")
    public void reviewProject() {
        System.out.println("Reviewing project.");
    }

    public void archiveProject() {
        System.out.println("Archiving project.");
    }
}

public class ProjectManagerApp {
    public static void main(String[] args) {
        ProjectManager manager = new ProjectManager();
        manager.processProject();
        manager.reviewProject();
        manager.archiveProject();

        try {
            Method[] methods = ProjectManager.class.getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(ImportantMethod.class)) {
                    ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                    System.out.println("Important Method: " + method.getName() + " - Level: " + annotation.level());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
