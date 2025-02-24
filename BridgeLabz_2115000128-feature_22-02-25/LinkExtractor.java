import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class LinkExtractor {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String LINK_PATTERN = "https?://[\\w.-]+(?:\\.[a-zA-Z]{2,6})?(?:/\\S*)?";

    public static void extractLinks(String text) {
        Pattern pattern = Pattern.compile(LINK_PATTERN);
        Matcher matcher = pattern.matcher(text);
        System.out.println("Extracted links from the text:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter a text to extract links from:");
        String inputText = scanner.nextLine();
        extractLinks(inputText);
        scanner.close();
    }
}
