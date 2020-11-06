import java.util.Locale;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        // put your code here
        double r = scanner.nextDouble();
        double s = Math.PI * r * r;
        System.out.println(s);
    }
}