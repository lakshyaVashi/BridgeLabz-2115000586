import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class EmailExtractor {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String EMAIL_PATTERN = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}";

    public static void extractEmails(String text) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(text);
        System.out.println("Extracted email addresses:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter the text to extract email addresses from:");
        String inputText = scanner.nextLine();
        extractEmails(inputText);
        scanner.close();
    }
}