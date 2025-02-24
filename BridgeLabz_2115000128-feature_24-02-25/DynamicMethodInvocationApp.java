import java.lang.reflect.*;
import java.util.Scanner;

class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

public class DynamicMethodInvocationApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            MathOperations operations = new MathOperations();
            System.out.print("Enter method name (add, subtract, multiply): ");
            String methodName = scanner.nextLine();
            System.out.print("Enter first number: ");
            int num1 = scanner.nextInt();
            System.out.print("Enter second number: ");
            int num2 = scanner.nextInt();

            Method method = MathOperations.class.getDeclaredMethod(methodName, int.class, int.class);
            Object result = method.invoke(operations, num1, num2);
            System.out.println("Result: " + result);
        } catch (NoSuchMethodException e) {
            System.out.println("Method not found.");
        } catch (IllegalAccessException | InvocationTargetException e) {
            System.out.println("Error invoking method: " + e.getMessage());
        }
    }
}