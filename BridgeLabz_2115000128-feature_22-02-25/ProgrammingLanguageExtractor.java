import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ProgrammingLanguageExtractor {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String LANGUAGE_PATTERN = "\\b(Java|Python|JavaScript|Go|C\\+\\+|C#|Ruby|PHP|Swift|Kotlin|Rust)\\b";

    public static void extractProgrammingLanguages(String text) {
        Pattern pattern = Pattern.compile(LANGUAGE_PATTERN);
        Matcher matcher = pattern.matcher(text);
        System.out.println("Extracted programming languages:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter a text to extract programming language names:");
        String inputText = scanner.nextLine();
        extractProgrammingLanguages(inputText);
        scanner.close();
    }
}
