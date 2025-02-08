import java.util.Arrays;

class Solution {
    public int sumOfPower(int[] nums) {
        // Sort array to handle min/max efficiently
        Arrays.sort(nums);
        
        long result = 0;
        long minSum = 0;
        long mod = 1_000_000_007;
        
        // For each number as potential maximum
        for (int i = 0; i < nums.length; i++) {
            // Calculate power: max^2 * min
            result = (result + (((long) nums[i] * nums[i]) % mod) * minSum) % mod;
            // Add current number as max^2 * itself as min
            result = (result + ((long) nums[i] * nums[i] % mod) * nums[i]) % mod;
            
            // Update minSum for next iteration
            // Each previous number can be minimum, multiply by 2 for next position
            minSum = (minSum * 2 + nums[i]) % mod;
        }
        
        return (int) result;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.sumOfPower(new int[] {1, 2, 3, 4, 5})); // 1^2 + 2^2 + 3^2 + 4^2 + 5^2 = 55
        System.out.println(sol.sumOfPower(new int[] {1, 2, 3, 4, 5, 6})); // 1^2 + 2^2 + 3^2 + 4^2 + 5^2 + 6^2 = 91
    }
}