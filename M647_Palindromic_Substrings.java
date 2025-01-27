/**
 * Solution class for counting palindromic substrings in a given string
 * LeetCode Problem 647: https://leetcode.com/problems/palindromic-substrings/
 */
class Solution {
    /**
     * Counts the total number of palindromic substrings in the input string
     * @param inputString the input string to analyze
     * @return total count of palindromic substrings
     */
    public int countSubstrings(String inputString) {
        int stringLength = inputString.length();
        int palindromeCount = 0;
        
        // Iterate through each character as potential center of palindrome
        for (int center = 0; center < stringLength; center++) {
            // Check for odd length palindromes (single character center)
            palindromeCount += expandAroundCenter(inputString, center, center);
            
            // Check for even length palindromes (between two characters)
            palindromeCount += expandAroundCenter(inputString, center, center + 1);
        }
        return palindromeCount;
    }

    /**
     * Helper method to count palindromes by expanding around a center
     * @param str the input string
     * @param leftPos left pointer for expansion
     * @param rightPos right pointer for expansion
     * @return count of palindromes found from this center
     */
    private int expandAroundCenter(String str, int leftPos, int rightPos) {
        int palindromeCount = 0;
        
        // Expand around center while characters match and bounds are valid
        while (leftPos >= 0 && rightPos < str.length() && 
               str.charAt(leftPos) == str.charAt(rightPos)) {
            palindromeCount++;
            leftPos--;
            rightPos++;
        }
        return palindromeCount;
    }
    
    /**
     * Main method for testing the solution
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1: String with no repeated characters
        System.out.println(solution.countSubstrings("abc"));  // Expected: 3
        
        // Test case 2: String with all same characters
        System.out.println(solution.countSubstrings("aaa"));  // Expected: 6
    }
}
