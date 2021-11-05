class Solution {
    public int missingNumber(int[] nums) {
        int check = (nums.length * (nums.length + 1)) / 2;
        int sum = 0;
            for (int num : nums) {
                sum = sum + num;
            }
        int res = check - sum;
        return res;
    }
}
