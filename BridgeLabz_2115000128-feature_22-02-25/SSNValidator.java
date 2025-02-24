import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class SSNValidator {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String SSN_PATTERN = "(?<!\\d)(\\d{3}-\\d{2}-\\d{4})(?!\\d)";

    public static void validateSSN(String text) {
        Pattern pattern = Pattern.compile(SSN_PATTERN);
        Matcher matcher = pattern.matcher(text);
        boolean found = false;
        while (matcher.find()) {
            found = true;
            System.out.println("✅ \"" + matcher.group(1) + "\" is valid");
        }
        if (!found) {
            System.out.println("❌ No valid SSN found in the input.");
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter a text to validate SSN:");
        String inputText = scanner.nextLine();
        validateSSN(inputText);
        scanner.close();
    }
}