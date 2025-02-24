import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class IPAddressValidator {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String IPV4_PATTERN =
            "^(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\." +
            "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\." +
            "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\." +
            "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)$";

    public static boolean isValidIPAddress(String ipAddress) {
        Pattern pattern = Pattern.compile(IPV4_PATTERN);
        Matcher matcher = pattern.matcher(ipAddress);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println("Enter an IPv4 address to validate:");
        String ipAddress = scanner.nextLine();
        if (isValidIPAddress(ipAddress)) {
            System.out.println("✅ \"" + ipAddress + "\" → Valid IPv4 address.");
        } else {
            System.out.println("❌ \"" + ipAddress + "\" → Invalid IPv4 address.");
        }
        scanner.close();
    }
}