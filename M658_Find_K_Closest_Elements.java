import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 658 - Find K Closest Elements
 * Problem: Find k closest integers to x in a sorted array
 * Time Complexity: O(n-k) where n is array length
 * Space Complexity: O(k) for result list
 */
class Solution {
    /**
     * Finds k numbers in arr that are closest to x
     * @param arr Sorted integer array
     * @param k Number of elements to return
     * @param x Target value to find closest elements to
     * @return List of k closest integers to x in ascending order
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // Initialize result list and sliding window bounds
        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = arr.length - 1;
        
        // Shrink window until we have k elements
        while (right - left >= k) {
            // Compare distances from x at both ends
            // If left element is further, move left pointer
            // If right element is further (or equal), move right pointer
            if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                left++;
            } else {
                right--;
            }
        }
        
        // Add all elements in the final window to result
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
        
        // Test case 1: Elements around middle value
        int[] test1 = {1, 2, 3, 4, 5};
        System.out.println("Test case 1 (k=4, x=3): " + 
            sol.findClosestElements(test1, 4, 3));  // Expected: [1,2,3,4]
            
        // Test case 2: Target outside array (left side)
        System.out.println("Test case 2 (k=4, x=-1): " + 
            sol.findClosestElements(test1, 4, -1)); // Expected: [1,2,3,4]
    }
}