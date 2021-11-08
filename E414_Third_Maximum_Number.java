class Solution {
    public int thirdMax(int[] nums) {
        //We use Long data type because the nums[i] can be > 2^31 - 1, which leads to a wrong case.
        long firstMax = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;
        
        int len = nums.length - 1;
        
        if (len == 0) return nums[0];
        else if (len == 1) return Math.max(nums[0], nums[1]);
        
        for (int num : nums) {
            if (num > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = num;
            } else if (num > secondMax && num < firstMax) {
                thirdMax = secondMax;
                secondMax = num;
            } else if (num > thirdMax && num < secondMax) {
                thirdMax = num;
            }
        }
        
        if (thirdMax == Long.MIN_VALUE) {
            return (int) firstMax;
        }
        return (int) thirdMax;
    }
}
