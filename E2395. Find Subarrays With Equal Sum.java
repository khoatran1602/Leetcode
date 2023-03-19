class Solution {
    public boolean findSubarrays(int[] nums) {
        if (nums.length < 3) return false;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            int sum = nums[i] + nums[i+1];
            if (set.contains(sum)) return true;
            set.add(sum);
        }
        return false;
    }
}
