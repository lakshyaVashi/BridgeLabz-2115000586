import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MeasureExecutionTime {}

interface Greeting {
    void sayHello(String name);
}

class GreetingImpl implements Greeting {
    @MeasureExecutionTime
    public void sayHello(String name) {
        System.out.println("Hello, " + name + "!");
    }
}

class UserService {
    @Inject
    private Greeting greeting;

    @MeasureExecutionTime
    public void greetUser(String name) {
        greeting.sayHello(name);
    }
}

class SimpleDIContainer {
    public static <T> T createInstance(Class<T> clazz) {
        try {
            T instance = clazz.getDeclaredConstructor().newInstance();
            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(Inject.class)) {
                    field.setAccessible(true);
                    Class<?> fieldType = field.getType();
                    Object dependency = fieldType.getDeclaredConstructor().newInstance();
                    field.set(instance, dependency);
                }
            }
            return instance;
        } catch (Exception e) {
            throw new RuntimeException("Failed to create instance: " + e.getMessage(), e);
        }
    }
}

class ExecutionTimer {
    public static void measureMethodExecution(Object obj) {
        Class<?> clazz = obj.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(MeasureExecutionTime.class)) {
                try {
                    method.setAccessible(true);
                    long startTime = System.nanoTime();
                    if (method.getParameterCount() == 0) {
                        method.invoke(obj);
                    }
                    long endTime = System.nanoTime();
                    System.out.println("Execution time of " + method.getName() + ": " + (endTime - startTime) + " ns");
                } catch (Exception e) {
                    System.out.println("Failed to execute method: " + e.getMessage());
                }
            }
        }
    }
}

public class TaskManagerApp5 {
    public static void main(String[] args) {
        UserService userService = SimpleDIContainer.createInstance(UserService.class);
        userService.greetUser("Alice");
        userService.greetUser("Bob");
        ExecutionTimer.measureMethodExecution(userService);
    }
}