import java.util.HashMap;

/**
 * LeetCode 659 - Split Array into Consecutive Subsequences
 * Problem: Check if array can be split into subsequences of length >= 3 with consecutive elements
 * Time Complexity: O(n) where n is array length
 * Space Complexity: O(n) for HashMaps
 */
class Solution {
    /**
     * Determines if the array can be split into valid consecutive subsequences
     * @param nums Array of integers to be split
     * @return true if valid split is possible, false otherwise
     */
    public boolean isPossible(int[] nums) {
        // Track frequency of each number
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        // Track frequency of numbers that can be appended to existing sequences
        HashMap<Integer, Integer> appendableSequences = new HashMap<>();

        // Count frequency of each number
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Process each number
        for (int num : nums) {
            if (frequencyMap.get(num) == 0) {
                // Number already used in a sequence
                continue;
            } else if (appendableSequences.getOrDefault(num, 0) > 0) {
                // Can append to existing sequence
                appendableSequences.put(num, appendableSequences.get(num) - 1);
                appendableSequences.put(num + 1, appendableSequences.getOrDefault(num + 1, 0) + 1);
            } else if (frequencyMap.getOrDefault(num + 1, 0) > 0 && 
                      frequencyMap.getOrDefault(num + 2, 0) > 0) {
                // Create new sequence of length 3
                frequencyMap.put(num + 1, frequencyMap.get(num + 1) - 1);
                frequencyMap.put(num + 2, frequencyMap.get(num + 2) - 1);
                appendableSequences.put(num + 3, appendableSequences.getOrDefault(num + 3, 0) + 1);
            } else {
                // Cannot form valid sequence
                return false;
            }
            frequencyMap.put(num, frequencyMap.get(num) - 1);
        }

        return true;
    }
    
    /**
     * Main method for testing the solution
     */
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Test case 1: Valid consecutive sequence
        int[] test1 = {1, 2, 3, 3, 4, 5};
        System.out.println("Test case 1 ([1,2,3,3,4,5]): " + 
            sol.isPossible(test1));  // Expected: true
            
        // Test case 2: Invalid sequence
        int[] test2 = {1, 2, 3, 3, 4, 4, 5, 5};
        System.out.println("Test case 2 ([1,2,3,3,4,4,5,5]): " + 
            sol.isPossible(test2));  // Expected: true
    }
}