class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        int len = 0;
        int index = 0;
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }
        for (Integer set : set1) {
            if (set2.contains(set)) {
                len++;
            }
        }
        int[] nums3 = new int[len];
        for (Integer set : set1) {
            if (set2.contains(set)) {
                nums3[index++] = set;
            }
        }
        return nums3;
    }
}
