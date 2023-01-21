class Solution {
    public boolean canJump(int[] nums) {
        // Initialize a variable to keep track of the maximum reachable index
        int maxReach = 0;
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // If the current index is greater than the maximum reachable index, return false
            if (i > maxReach) return false;
            // Update the maximum reachable index
            maxReach = Math.max(maxReach, i + nums[i]);
            // If the maximum reachable index is greater than or equal to the last index of the array, return true
            if (maxReach >= nums.length - 1) return true;
        }
        // If the loop completes, return false
        return false;
    }
}
