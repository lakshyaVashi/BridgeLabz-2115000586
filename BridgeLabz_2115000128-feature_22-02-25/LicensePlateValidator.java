import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class LicensePlateValidator {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String LICENSE_PLATE_PATTERN = "^[A-Z]{2}\\d{4}$";

    public static boolean isValidLicensePlate(String licensePlate) {
        Pattern pattern = Pattern.compile(LICENSE_PLATE_PATTERN);
        Matcher matcher = pattern.matcher(licensePlate);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.print("Enter a license plate number to validate: ");
        String licensePlate = scanner.nextLine();
        if (isValidLicensePlate(licensePlate)) {
            System.out.println("✅ \"" + licensePlate + "\" → Valid");
        } else {
            System.out.println("❌ \"" + licensePlate + "\" → Invalid");
        }
        scanner.close();
    }
}