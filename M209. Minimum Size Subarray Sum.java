class Solution {
    // This method finds the minimum length of a contiguous subarray of nums 
    // that has a sum of at least target
    public int minSubArrayLen(int target, int[] nums) {
        // Get the length of nums and initialize some variables
        int length = nums.length;
        int minimumLength = Integer.MAX_VALUE;
        int sum = 0;
        int leftIndex = 0;
        
        // Iterate over nums and find the minimum length of a subarray with a sum >= target
        for (int i = 0; i < length; i++) {
            // Add the current number to the sum
            sum += nums[i];
            
            // If the sum is greater than or equal to target, update the minimum length
            while (sum >= target) {
                minimumLength = Math.min(minimumLength, i - leftIndex + 1);
                sum -= nums[leftIndex];
                leftIndex++;
            }
        }
        
        // If no subarray was found with a sum >= target, return 0, otherwise return the minimum length
        return minimumLength == Integer.MAX_VALUE ? 0 : minimumLength;
    }
}
