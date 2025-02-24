import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CurrencyValueExtractor {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String CURRENCY_PATTERN = "\\$?\\b\\d+\\.\\d{2}\\b";

    public static void extractCurrencyValues(String text) {
        Pattern pattern = Pattern.compile(CURRENCY_PATTERN);
        Matcher matcher = pattern.matcher(text);
        System.out.println("Extracted currency values:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter a text to extract currency values:");
        String inputText = scanner.nextLine();
        extractCurrencyValues(inputText);
        scanner.close();
    }
}
