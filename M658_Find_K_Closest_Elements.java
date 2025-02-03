import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 658 - Find K Closest Elements
 * Problem: Find k closest integers to target x in sorted array
 * Time Complexity: O(n-k) where n is array length
 * Space Complexity: O(k) for result list
 */
class Solution {
    /**
     * Finds k closest elements to target value x using sliding window
     * @param arr Sorted array of integers
     * @param k Number of closest elements to find
     * @param x Target value
     * @return List of k closest elements in ascending order
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = arr.length - 1;
        
        // Shrink window from both ends until k elements remain
        while (right - left >= k) {
            // Remove element further from x
            if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                left++;  // Left element is further, shrink from left
            } else {
                right--;    // Right element is further (or equal), shrink from right
            }
        }
        
        // Add remaining k elements to result
        for (int i = left; i <= right; i++) {
            result.add(arr[i]);
        }
        return result;
    }

    /**
     * Main method for testing the solution
     */
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Test cases
        System.out.println("Test case 1: " + sol.findClosestElements(new int[]{1,2,3,4,5}, 4, 3));  // Should print [1,2,3,4]
        System.out.println("Test case 2: " + sol.findClosestElements(new int[]{1,2,3,4,5}, 4, -1)); // Should print [1,2,3,4]
    }
}