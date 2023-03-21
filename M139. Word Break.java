class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Creating a HashSet from the given word dictionary.
        Set<String> dict = new HashSet<>(wordDict);
        // Storing the length of the given string.
        int len = s.length();
        // Creating a boolean array to keep track of whether a substring till the current index can be segmented into words from the dictionary or not.
        boolean[] dp = new boolean[len + 1];
        // Initializing the first element of the boolean array to be true.
        dp[0] = true;
        // Looping through each index of the boolean array to check if a substring till that index can be segmented into words from the dictionary.
        for (int i = 1; i <= len; i++) {
        // If a substring till the previous index can be segmented into words from the dictionary, then we check all the substrings starting from the current index till the end of the given string.
            if (dp[i - 1]) {
                for (int j = i; j <= len; j++) {
        // Extracting a substring starting from the current index till the end of the given string.
                    String substr = s.substring(i - 1, j);
        // If the current substring is present in the dictionary, then we mark the corresponding index in the boolean array to be true.
                    if (dict.contains(substr)) {
                        dp[j] = true;
        // If the last element of the boolean array is true, then we can segment the entire string into words from the dictionary.
                        if (dp[len]) {
                            return true;
                        }
                    }
                }
            }
        }
        // Returning the value at the last index of the boolean array, which indicates whether the entire string can be segmented into words from the dictionary or not.
        return dp[len];
    }
}
