import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        Random random = new Random(a + b);

        long sum = 0;
        for (int i = 0; i < n; i++) {
            int numberInRange = random.nextInt(b - a + 1) + a;
            sum += numberInRange;
        }
        System.out.println(sum);
    }
}