class Converter {

    /**
     * It returns a double value or 0 if an exception occurred
     */
    public static double convertStringToDouble(String input) {
        double number;
        try {
            number = Double.parseDouble(input);
        } catch (Exception e) {
            number = 0.0;
        }
        return number;
    }
}