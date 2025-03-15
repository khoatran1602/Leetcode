class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers cannot be palindromes
        if (x < 0) {
            return false;
        }
        
        // Store original number since we'll modify x during reversal
        int originalNumber = x;
        int reversedNumber = 0;
        
        // Reverse the number by building it digit by digit
        while (x != 0) {
            // Get the last digit
            int lastDigit = x % 10;
            
            // Build reversed number: multiply by 10 to shift left and add last digit
            reversedNumber = reversedNumber * 10 + lastDigit;
            
            // Remove the last digit from original number
            x = x / 10;
        }
        
        // Number is palindrome if original equals reversed
        // Note: 0 is also a palindrome
        return originalNumber == 0 || originalNumber == reversedNumber;
    }
}
-----------------------------------------------------------------------------------------------------
class Solution {
    public boolean isPalindrome(int x) {
        // Convert integer to string for easier character comparison
        String numStr = String.valueOf(x);
        
        // Use two pointers: one from start, one from end
        int leftPointer = 0;
        int rightPointer = numStr.length() - 1;
        
        // Compare characters from both ends moving towards center
        while (leftPointer < rightPointer) {
            // If characters don't match, it's not a palindrome
            if (numStr.charAt(leftPointer++) != numStr.charAt(rightPointer--)) {
                return false;
            }
        }
        
        // If we made it through the loop, it's a palindrome
        return true;
    }
}
-------------------------------------------------------------------------------
