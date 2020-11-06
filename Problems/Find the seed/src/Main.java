import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] maxes = new int[b - a + 1];

        for (int seed = a; seed <= b; seed++) {
            Random random = new Random(seed);
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                int randomNumber = random.nextInt(k);
                if (randomNumber > max) {
                    max = randomNumber;
                }
            }
            maxes[seed - a] = max;
        }

        int minIndex = 0;
        for (int i = 1; i < maxes.length; i++) {
            if (maxes[i] < maxes[minIndex]) {
                minIndex = i;
            }
        }
        int seed = minIndex + a;
        System.out.println(seed);
        System.out.println(maxes[minIndex]);
    }
}