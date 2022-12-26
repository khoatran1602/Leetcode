class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
       int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] < nums2[j] && indexOf(nums2, nums1[i]) < j) {
                    res[i] = nums2[j];
                    break;
                } else {
                    res[i] = -1;
                }
            }
        }
        return res;
    }

    public int indexOf(int[] nums, int num) {
        for (int i = 0; i < nums.length; i++) {
            if (num == nums[i]) return i;
        }
        return 0;
    }
}
