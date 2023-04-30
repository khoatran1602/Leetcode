import java.util.HashMap;

class Solution {
    // This method finds the minimum window in string s which contains all the characters in string t
    public String minWindow(String s, String t) {
        // If the length of s is less than the length of t, then there is no valid window, return an empty string
        if (s.length() < t.length()) return "";

        // Create hash maps to keep track of the frequency of characters in t and s
        HashMap<Character, Integer> tFreqMap = new HashMap<>();
        HashMap<Character, Integer> sFreqMap = new HashMap<>();

        // Initialize variables for the sliding window approach
        int windowStart = 0, windowEnd = 0, windowLength = 0, numCharsMatched = 0;
        int sLength = s.length(), tLength = t.length();
        int minWindowLength = Integer.MAX_VALUE;

        // Populate the frequency map for string t
        for (int i = 0; i < tLength; i++) {
            char c = t.charAt(i);
            tFreqMap.put(c, tFreqMap.getOrDefault(c, 0) + 1);
        }

        // Use a sliding window approach to find the minimum window
        while (windowEnd < sLength) {
            char currentChar = s.charAt(windowEnd++);
            if (tFreqMap.containsKey(currentChar)) {
                // Update the frequency map for string s
                sFreqMap.put(currentChar, sFreqMap.getOrDefault(currentChar, 0) + 1);
                // If the frequency of currentChar in s is equal to its frequency in t, increment numCharsMatched
                if (sFreqMap.get(currentChar).equals(tFreqMap.get(currentChar))) {
                    numCharsMatched++;
                }
            }

            // If all characters in t have been matched, move the window start to find the minimum window
            while (numCharsMatched == tFreqMap.size()) {
                // Update the minimum window length if a smaller window is found
                if (windowEnd - windowStart < minWindowLength) {
                    windowLength = windowEnd - windowStart;
                    minWindowLength = windowLength;
                }
                // Move the window start and update the frequency map for string s
                char charToRemove = s.charAt(windowStart++);
                if (tFreqMap.containsKey(charToRemove)) {
                    if (sFreqMap.get(charToRemove).equals(tFreqMap.get(charToRemove))) {
                        numCharsMatched--;
                    }
                    sFreqMap.put(charToRemove, sFreqMap.get(charToRemove) - 1);
                }
            }
        }

        // Return the minimum window, or an empty string if no valid window was found
        return minWindowLength == Integer.MAX_VALUE ? "" : s.substring(windowStart - 1, windowStart + windowLength - 1);
    }
}
