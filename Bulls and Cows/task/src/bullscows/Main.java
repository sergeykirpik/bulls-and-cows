package bullscows;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

    public static void main(String[] args) {
        SecretGenerator secretGen = initSecretGenerator();
        if (secretGen == null) {
            return;
        }
        System.out.print(secretGen.describe());
        String secret = secretGen.getSecret();

        System.out.println("Okay, let's start a game!");

        int turn = 0;
        String guess;
        while (true) {
            turn++;
            System.out.printf("Turn %d:\n", turn);
            guess = readGuess(secret.length());
            CountResult bullsAndCows = countBullsAndCows(guess, secret);
            printGrade(bullsAndCows);
            if (bullsAndCows.bulls == secret.length()) {
                break;
            }
        }
        System.out.println("Congratulations! You guessed the secret code.");
    }

    static String readGuess(int length) {
        boolean valid = false;
        String input = null;
        while (!valid) {
            input = scanner.nextLine();
            valid = input.length() == length;
        }
        return input;
    }

    static SecretGenerator initSecretGenerator() {
        String input;

        System.out.println("Input the length of the secret code:");
        input = scanner.nextLine();
        if (!input.matches("\\d+")) {
            System.out.printf("Error: %s isn't a valid number.\n", input);
            return null;
        }
        int secretLength = Integer.parseInt(input);

        System.out.println("Input the number of possible symbols in the code:");
        input = scanner.nextLine();
        if (!input.matches("\\d+")) {
            System.out.printf("Error: %s isn't a valid number.\n", input);
            return null;
        }
        int alphabetLength = Integer.parseInt(input);

        boolean impossibleSecretCode =
            secretLength > alphabetLength ||
            secretLength == 0 ||
            alphabetLength == 0 ||
            alphabetLength > SecretGenerator.MAX_ALPHA_LENGTH
        ;
        if (impossibleSecretCode) {
            System.out.printf("Error: it's not possible to generate a code with a length of %d with %d unique symbols.\n",
            secretLength, alphabetLength);
            return null;
        }

        return new SecretGenerator(secretLength, alphabetLength);
    }

    static void printGrade(CountResult countResult) {
        int bulls = countResult.bulls;
        int cows = countResult.cows;
        if (bulls > 0 && cows > 0) {
            System.out.printf("Grade: %d bull%s %d cow%s.\n", bulls, pluralize(bulls), cows, pluralize(cows));
        } else if (bulls > 0) {
            System.out.printf("Grade: %d bull%s.\n", bulls, pluralize(bulls));
        } else if (cows > 0) {
            System.out.printf("Grade: %d cow%s.\n", cows, pluralize(cows));
        } else {
            System.out.print("None.\n");
        }
    }

    static CountResult countBullsAndCows(String number, String secret) {
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == secret.charAt(i)) {
                bulls++;
                continue;
            }
            for (int j = 0; j < secret.length(); j++) {
                if (number.charAt(i) == secret.charAt(j)) {
                    cows++;
                    break;
                }
            }
        }
        return new CountResult(bulls, cows);
    }

    static String pluralize(int count) {
        return count == 1 ? "" : "s";
    }

    static private class CountResult {
        public final int bulls;
        public final int cows;

        public CountResult(int bulls, int cows) {
            this.bulls = bulls;
            this.cows = cows;
        }
    }
}
