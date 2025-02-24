import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BadWordCensor {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<String> BAD_WORDS = Arrays.asList("damn", "stupid");

    public static String censorBadWords(String text) {
        String censoredText = text;
        for (String badWord : BAD_WORDS) {
            censoredText = censoredText.replaceAll("(?i)\\b" + badWord + "\\b", "****");
        }
        return censoredText;
    }

    public static void main(String[] args) {
        System.out.println("Enter a sentence to censor bad words:");
        String inputText = scanner.nextLine();
        String result = censorBadWords(inputText);
        System.out.println("Censored output:");
        System.out.println(result);
        scanner.close();
    }
}
