import java.util.Scanner;

class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        solution1();
    }

    static void solution1() {
        String[] digits = scanner.nextLine().split("");
        int sum = 0;
        for (int i = 0; i < digits.length; i++) {
            int digit = Integer.parseInt(digits[i]);
            if (i < 3) {
                sum += digit;
            } else {
                sum -= digit;
            }
        }
        System.out.println(sum == 0 ? "Lucky" : "Regular");
    }

    static void solution2() {
        String ticket = scanner.nextLine();
        int sum = 0;
        for (int i = 0; i < ticket.length(); i++) {
            int digit = Character.getNumericValue(ticket.charAt(i));
            if (i < 3) {
                sum += digit;
            } else {
                sum -= digit;
            }
        }
        System.out.println(sum == 0 ? "Lucky" : "Regular");
    }

    static void solution3() {
        char[] ticket = scanner.nextLine().toCharArray();
        int sum = 0;
        for (int i = 0; i < ticket.length; i++) {
            int digit = Character.getNumericValue(ticket[i]);
            if (i < 3) {
                sum += digit;
            } else {
                sum -= digit;
            }
        }
        System.out.println(sum == 0 ? "Lucky" : "Regular");
    }
}