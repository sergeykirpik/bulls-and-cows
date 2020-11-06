import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] sentence = scanner.nextLine().toCharArray();
        char[] needle = "the".toCharArray();

        int index = -1;
        for (int i = 0; i < sentence.length - needle.length + 1 && index < 0; i++) {
            boolean found = true;
            for (int j = 0; j < needle.length; j++) {
                found &= Character.toLowerCase(sentence[i + j]) == needle[j];
            }
            if (found) {
                index = i;
            }
        }
        System.out.println(index);
    }
}