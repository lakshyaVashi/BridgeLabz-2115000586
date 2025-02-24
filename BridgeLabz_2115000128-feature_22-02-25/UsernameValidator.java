import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class UsernameValidator {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String USERNAME_PATTERN = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";

    public static boolean isValidUsername(String username) {
        Pattern pattern = Pattern.compile(USERNAME_PATTERN);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.print("Enter a username to validate: ");
        String username = scanner.nextLine();

        if (isValidUsername(username)) {
            System.out.println("✅ \"" + username + "\" → Valid");
        } else {
            System.out.println("❌ \"" + username + "\" → Invalid");
        }

        scanner.close();
    }
}
