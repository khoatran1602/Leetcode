import java.util.Arrays;

/**
 * LeetCode 2681 - Power of Heroes
 * Time Complexity: O(n log n) due to sorting
 * Space Complexity: O(1) as we only use constant extra space
 */
class Solution {
    // Constant for modulo operations to prevent overflow
    private static final long MOD = 1_000_000_007;
    
    /**
     * Calculates the sum of power for all possible hero combinations
     * Power = min(subset) * max(subset)^2 for each possible subset
     * @param nums Array of hero power values
     * @return Sum of power for all possible combinations
     */
    public int sumOfPower(int[] nums) {
        // Sort to efficiently handle min/max calculations
        Arrays.sort(nums);
        
        long result = 0;
        // minSum keeps track of possible minimum values contribution
        long minSum = 0;
        
        // Process each number as a potential maximum value
        for (int i = 0; i < nums.length; i++) {
            long currentNum = nums[i];
            // Square of current number (potential maximum)
            long squaredNum = (currentNum * currentNum) % MOD;
            
            // Add contribution of all previous minimums with current maximum
            result = (result + (squaredNum * minSum) % MOD) % MOD;
            
            // Add contribution when current number is both min and max
            result = (result + (squaredNum * currentNum) % MOD) % MOD;
            
            // Update minSum for next iteration:
            // - Multiply previous minSum by 2 (as each previous min can be used twice)
            // - Add current number as a new possible minimum
            minSum = (minSum * 2 + currentNum) % MOD;
        }
        
        return (int) result;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.sumOfPower(new int[] {1, 2, 3, 4, 5})); // 1^2 + 2^2 + 3^2 + 4^2 + 5^2 = 55
        System.out.println(sol.sumOfPower(new int[] {1, 2, 3, 4, 5, 6})); // 1^2 + 2^2 + 3^2 + 4^2 + 5^2 + 6^2 = 91
    }
}