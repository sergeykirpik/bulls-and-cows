import java.util.Locale;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        double d = Math.sqrt(b * b - 4 * a * c);
        double x1 = -(b + d) / (2 * a);
        double x2 = -(b - d) / (2 * a);
        System.out.println(Math.min(x1, x2));
        System.out.println(Math.max(x1, x2));
    }
}