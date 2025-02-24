import java.util.Scanner;
import java.util.regex.Pattern;

public class CreditCardValidator {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String VISA_PATTERN = "^4\\d{15}$";
    private static final String MASTERCARD_PATTERN = "^5\\d{15}$";

    public static boolean isValidVisa(String cardNumber) {
        return Pattern.matches(VISA_PATTERN, cardNumber);
    }

    public static boolean isValidMasterCard(String cardNumber) {
        return Pattern.matches(MASTERCARD_PATTERN, cardNumber);
    }

    public static void main(String[] args) {
        System.out.println("Enter a credit card number to validate:");
        String cardNumber = scanner.nextLine();

        if (isValidVisa(cardNumber)) {
            System.out.println("✅ \"" + cardNumber + "\" → Valid Visa card.");
        } else if (isValidMasterCard(cardNumber)) {
            System.out.println("✅ \"" + cardNumber + "\" → Valid MasterCard.");
        } else {
            System.out.println("❌ \"" + cardNumber + "\" → Invalid credit card number.");
        }

        scanner.close();
    }
}
