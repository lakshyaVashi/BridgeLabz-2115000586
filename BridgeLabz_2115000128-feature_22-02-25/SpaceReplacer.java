import java.util.Scanner;

public class SpaceReplacer {
    private static final Scanner scanner = new Scanner(System.in);

    public static String replaceMultipleSpaces(String text) {
        return text.replaceAll("\\s+", " ");
    }

    public static void main(String[] args) {
        System.out.println("Enter a text with multiple spaces:");
        String inputText = scanner.nextLine();
        String result = replaceMultipleSpaces(inputText);
        System.out.println("Output with single spaces:");
        System.out.println(result);
        scanner.close();
    }
}