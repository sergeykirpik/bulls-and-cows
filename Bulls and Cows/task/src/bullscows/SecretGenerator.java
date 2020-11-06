package bullscows;

import java.util.Random;

class SecretGenerator {
    private static final String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyz";
    public static final int MAX_ALPHA_LENGTH = ALPHABET.length();

    private final Random randomGen = new Random();

    private final String secret;
    private final int secretLength;
    private final int alphabetLength;

    public SecretGenerator(int secretLength, int alphabetLength) {
        this.secretLength = secretLength;
        this.alphabetLength = alphabetLength;
        this.secret = generate();
    }

    public String getSecret() {
        return secret;
    }

    public String describe() {
        String stars = "*".repeat(secretLength);
        StringBuilder range = new StringBuilder();
        if (alphabetLength > 10) {
            range.append("0-9, a");
            if (alphabetLength > 11) {
                range.append('-').append(ALPHABET.charAt(alphabetLength - 1));
            }
        } else {
            range.append("0");
            if (alphabetLength > 1) {
                range.append('-').append(ALPHABET.charAt(alphabetLength - 1));
            }
        }
        return String.format("The secret is prepared: %s (%s).\n", stars, range);
    }

    private String generate() {
        int maxLength = ALPHABET.length();
        if (secretLength > maxLength || alphabetLength > maxLength) {
            return "";
        }
        char[] secret = new char[secretLength];
        for (int i = 0; i < secret.length; i++) {
            while (true) {
                char symbol = randomSymbol();
                if (!contains(secret, symbol)) {
                    secret[i] = symbol;
                    break;
                }
            }
        }
        return String.valueOf(secret);
    }

    private char randomSymbol() {
        int randomIndex = randomGen.nextInt(alphabetLength);
        return ALPHABET.charAt(randomIndex);
    }

    private boolean contains(char[] arr, char c) {
        for (char el: arr) {
            if (el == c) {
                return true;
            }
        }
        return false;
    }
}
