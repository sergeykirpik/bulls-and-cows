class ArraySorting {
    /**
     * @param array unordered sequence of strings
     * @return ordered array of strings
     */
    public static String[] sortArray(String[] array) {
        String[] sorted = java.util.Arrays.copyOf(array, array.length);
        java.util.Arrays.sort(sorted);

        return sorted;
    }
}