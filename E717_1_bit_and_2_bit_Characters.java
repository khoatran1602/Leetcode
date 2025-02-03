/**
 * LeetCode Problem 717: 1-bit and 2-bit Characters
 * 
 * This class determines if the last character in a binary sequence must be a one-bit character.
 * Special characters are encoded in either:
 * - One bit (0)
 * - Two bits (10 or 11)
 * 
 * Time Complexity: O(n) where n is the length of bits array
 * Space Complexity: O(1) as we only use constant extra space
 */
class Solution {
    /**
     * Determines if the last character must be a one-bit character.
     * Walks through the array counting characters based on their encoding:
     * - If current bit is 0, it's a one-bit character
     * - If current bit is 1, it's a two-bit character (10 or 11)
     * 
     * Example:
     * bits = [1,0,0] -> true
     * Parsing: [10,0] -> The last character must be one-bit (0)
     * 
     * @param bits Array representing the sequence of bits
     * @return true if the last character must be one-bit, false otherwise
     */
    public boolean isOneBitCharacter(int[] bits) {
        // Start from the beginning of the array
        int i = 0;
        
        // Process all characters except the last one
        while (i < bits.length - 1) {
            // If current bit is 1, skip two positions (2-bit character)
            // If current bit is 0, skip one position (1-bit character)
            i += bits[i] + 1;
        }
        
        // If we land exactly at the last position, it must be a one-bit character
        return i == bits.length - 1; // true if last character is one-bit
    }
    
    /**
     * Main method for testing the solution with example test cases
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: [1,0,0] -> true
        // Parsing: [10,0] -> Last character is one-bit
        int[] bits = {1, 0, 0};
        System.out.println(solution.isOneBitCharacter(bits));  // Expected: true

        // Test case 2: [1,1,1,0] -> false
        // Parsing: [11,10] -> Last character is part of two-bit character
        bits = new int[]{1, 1, 1, 0};
        System.out.println(solution.isOneBitCharacter(bits));  // Expected: false
    }
}