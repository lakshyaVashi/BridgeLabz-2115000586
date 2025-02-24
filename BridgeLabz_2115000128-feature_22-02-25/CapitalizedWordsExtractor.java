import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CapitalizedWordsExtractor {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String CAPITALIZED_WORD_PATTERN = "\\b[A-Z][a-z]*\\b";

    public static void extractCapitalizedWords(String text) {
        Pattern pattern = Pattern.compile(CAPITALIZED_WORD_PATTERN);
        Matcher matcher = pattern.matcher(text);
        System.out.println("Extracted capitalized words:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter a sentence to extract capitalized words from:");
        String inputText = scanner.nextLine();
        extractCapitalizedWords(inputText);
        scanner.close();
    }
}
