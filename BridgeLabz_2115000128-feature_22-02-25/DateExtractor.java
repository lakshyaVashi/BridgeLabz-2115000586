import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class DateExtractor {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String DATE_PATTERN = "\\b(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/([0-9]{4})\\b";

    public static void extractDates(String text) {
        Pattern pattern = Pattern.compile(DATE_PATTERN);
        Matcher matcher = pattern.matcher(text);
        System.out.println("Extracted dates in dd/mm/yyyy format:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter a text to extract dates from:");
        String inputText = scanner.nextLine();
        extractDates(inputText);
        scanner.close();
    }
}