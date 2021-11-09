class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int index = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                index++;
                max = Math.max(max, index);
            }
            if (nums[i] == 0) {
                index = 0;
            }
        }
        return max;
    }
}
