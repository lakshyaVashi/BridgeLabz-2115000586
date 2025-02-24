import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RepeatingWordFinder {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String REPEATING_WORD_PATTERN = "\\b(\\w+)(?:\\s+\\1)+\\b";

    public static void findRepeatingWords(String text) {
        Pattern pattern = Pattern.compile(REPEATING_WORD_PATTERN, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        System.out.println("Repeating words found:");
        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter a sentence to find repeating words:");
        String inputText = scanner.nextLine();
        findRepeatingWords(inputText);
        scanner.close();
    }
}