class Solution {

    /**
     * This method generates a string of n characters.
     * If n is odd, it calls the repeat method to add n random lowercase letters to a StringBuilder object and returns the resulting string.
     * If n is even, it enters a loop that generates a string with n-1 characters followed by one character that is different from the previous one.
     * If the resulting string ends with two identical characters, it removes the last one and adds a different one.
     *
     * @param n The number of characters to generate.
     * @return A string of n random lowercase letters of the English alphabet.
     */
    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        if (n % 2 != 0) {
            repeat(n, sb);
            return sb.toString();
        }
        while (n > 0) {
            if (n % 2 == 0) {
                repeat(n - 1, sb);
                n = 1;
            } else {
                repeat(1, sb);
                n = 0;
            }
        }
        if (sb.charAt(sb.length() - 1) == sb.charAt(sb.length() - 2)) {
            sb.deleteCharAt(sb.length() - 1);
            repeat(1, sb);
        }
        return sb.toString();
    }

    /**
     * This method generates a string of n random lowercase letters of the English alphabet and appends it to a StringBuilder object.
     *
     * @param n  The number of characters to generate.
     * @param sb The StringBuilder object to append the generated string to.
     */
    public static void repeat(int n, StringBuilder sb) {
        Random random = new Random();
        int randomNum = random.nextInt(26) + 1;
        sb.append(String.valueOf((char) (randomNum + 96)).repeat(Math.max(0, n)));
    }
}
