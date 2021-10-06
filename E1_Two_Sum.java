class Solution {
    public int[] twoSum(int[] nums, int target) {
      Map<Integer, Integer> map = new Map<>();
      for (int i = 0; i < nums.length; i++) {
        map.put(nums[i], i);
    }
    for (int i = 0; i < nums.length; i++) {
      int foundNumber = target - nums[i];
      if (map.containsKey(foundNumber) && map.get(nums[i]) != i) {
        return new int[] {i, map.get(nums[i])};
      }
      throw new IllegalArgumentException("No two sum solution");
    }
}
