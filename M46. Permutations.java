class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        List<Integer> subset = new ArrayList();
        boolean map[] = new boolean[nums.length];
        helper(nums, subset, ans, map);
        return ans;
    }

    public void helper(int nums[], List<Integer> subset, List<List<Integer>> ans, boolean map[]) {
        if (subset.size() == nums.length) {
            ans.add(new ArrayList(subset));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!map[i]) {
                subset.add(nums[i]);
                map[i] = true;
                helper(nums, subset, ans, map);
                subset.remove(subset.size() - 1);
                map[i] = false;
            }
        }
    }
}
