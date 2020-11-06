import java.util.Locale;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        StringBuilder result = new StringBuilder();
        while (true) {
            String input = scanner.nextLine();
            if ("0".equals(input)) {
                break;
            }
            try {
                int number = Integer.parseInt(input);
                result.append(number * 10).append('\n');
            } catch (NumberFormatException e) {
                result.append("Invalid user input: ").append(input).append('\n');
            }
        }
        System.out.print(result);
    }
}