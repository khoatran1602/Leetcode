class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0.0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double max = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            max = Math.max(max, sum);
        }
        return max / k;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        System.out.println(sol.findMaxAverage(nums, k));
    }
}