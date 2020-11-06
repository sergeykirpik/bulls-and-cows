import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] dna = scanner.nextLine().toCharArray();
        StringBuilder encoded = new StringBuilder(dna.length);

        char prev = dna[0];
        int count = 0;
        for (char curr: dna) {
            if (prev != curr) {
                encoded.append(prev).append(count);
                count = 1;
            } else {
                count++;
            }
            prev = curr;
        }
        encoded.append(prev).append(count);
        System.out.println(encoded);
    }
}