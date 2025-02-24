import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface BugReports {
    BugReport[] value();
}

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

class TaskManager {
    @BugReport(description = "Null pointer exception when input is null.")
    @BugReport(description = "Array index out of bounds in edge cases.")
    public void processTask() {
        System.out.println("Processing task.");
    }
}

public class TaskManagerApp2 {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        manager.processTask();

        try {
            Method method = TaskManager.class.getMethod("processTask");
            if (method.isAnnotationPresent(BugReports.class)) {
                BugReports reports = method.getAnnotation(BugReports.class);
                for (BugReport report : reports.value()) {
                    System.out.println("Bug Report: " + report.description());
                }
            } else if (method.isAnnotationPresent(BugReport.class)) {
                BugReport report = method.getAnnotation(BugReport.class);
                System.out.println("Bug Report: " + report.description());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}