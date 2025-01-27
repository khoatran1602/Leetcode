class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.contains(text2)) return text1.length();
        // initialize an array to store the length of the longest common subsequence
        int[] memo = new int[text2.length() + 1];
        // convert the input strings to character arrays
        char[] chars1 = text1.toCharArray(), chars2 = text2.toCharArray();
        // loop through the character array for text1 backwards
        for (int i = chars1.length - 1; i >= 0; i--) {
            // initialize variables to keep track of the previous and current max length
            int previous = 0, current = 0;
            // loop through the character array for text2 backwards
            for (int j = chars2.length - 1; j >= 0; j--) {
                // store the value of memo[j] in a temporary variable
                int temp = memo[j];
                // determine the max length of the common subsequence ending at this position
                int max;
                if (chars1[i] == chars2[j]) {
                    max = previous + 1;
                } else {
                    max = Math.max(temp, current);
                }
                // update the memo array and the current max length
                memo[j] = current = max;
                // update the previous max length for the next iteration
                previous = temp;
            }
        }
        // return the length of the longest common subsequence
        return memo[0];
    }
}
