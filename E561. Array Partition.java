class Solution {
    // Entry point method to find the sum of smallest elements in each pair of given array
    public int arrayPairSum(int[] nums) {
        // if array length is less than 2 return sum of all element
        if (nums.length < 2) return nums[0] + nums[1];
        // Initialize the result variable to store sum of smallest elements
        int res = 0;
        // Sort the array
        Arrays.sort(nums);
        // Iterate through the array with step of 2
        for (int i = 0; i < nums.length; i = i + 2) {
            // Add the current element to the result
            res = res + nums[i];
        }
        // Return the result
        return res;
    }
}
