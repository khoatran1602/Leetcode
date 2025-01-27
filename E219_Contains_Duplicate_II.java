class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num) && count - map.get(num) <= k) return true;
            map.put(num, count);
            count++;
        }
        return false;
    }
}
