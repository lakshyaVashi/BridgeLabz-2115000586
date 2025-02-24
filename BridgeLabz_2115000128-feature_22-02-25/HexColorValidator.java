import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class HexColorValidator {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String HEX_COLOR_PATTERN = "^#([a-fA-F0-9]{6})$";

    public static boolean isValidHexColor(String hexColor) {
        Pattern pattern = Pattern.compile(HEX_COLOR_PATTERN);
        Matcher matcher = pattern.matcher(hexColor);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.print("Enter a hex color code to validate: ");
        String hexColor = scanner.nextLine();
        if (isValidHexColor(hexColor)) {
            System.out.println("✅ \"" + hexColor + "\" → Valid");
        } else {
            System.out.println("❌ \"" + hexColor + "\" → Invalid");
        }
        scanner.close();
    }
}