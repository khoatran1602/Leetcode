class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        int limit = nums.length / 2;
        for (Integer num : hashMap.keySet()) {
            if (hashMap.get(num) > limit) return num;
        }
        return 0;
    }
}
