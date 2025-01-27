class Solution {
  public String longestPalindrome(String s) {
    String longestPalindrome = ""; // Initialize an empty string to store the longest palindrome found
    int maxLength = 0; // Initialize a variable to store the length of the longest palindrome found
    for(int i = 0; i < s.length(); i++) { // Iterate over each character in the string
      if(isPalindrome(s, i - maxLength - 1, i)) { // Check if a palindrome centered at i with length maxLength+1 exists
        longestPalindrome = s.substring(i - maxLength - 1, i + 1); // Update longestPalindrome to the new palindrome
        maxLength += 2; // Update maxLength to reflect the new longest palindrome found
      } else if(isPalindrome(s, i - maxLength, i)){ // Check if a palindrome centered at i with length maxLength exists
        longestPalindrome = s.substring(i - maxLength, i + 1); // Update longestPalindrome to the new palindrome
        maxLength += 1; // Update maxLength to reflect the new longest palindrome found
      }
    }
    return longestPalindrome; // Return the longest palindrome found
  }
  
  public boolean isPalindrome(String s, int start, int end) {
    if (start < 0) return false; // If start index is less than 0, then it is out of bounds
    while (start < end) { // Check if the string is a palindrome
      if(s.charAt(start++) != s.charAt(end--)) return false; // If any characters don't match, it's not a palindrome
    }
    return true; // If the loop completes without returning false, it's a palindrome
  }
}
