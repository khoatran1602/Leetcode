class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            if (nums[0] == target) return 0;
            else return -1;
        }
        int index = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i+1]) {
                index = i;
                break;
            }
        }
        int left = BinarySearch(nums, 0, index, target);
        int right = BinarySearch(nums, index + 1, nums.length - 1, target);
        if (left == -1 && right == -1) return -1;
        return left == -1 ? right : left;
    }

    public int BinarySearch(int[] nums, int start, int end, int target) {
        if (start > end) return -1;
        int mid = (start + end) / 2;
        if (nums[mid] == target) return mid;
        if (nums[mid] < target) return BinarySearch(nums, mid + 1, end, target);
        else return BinarySearch(nums, start, mid - 1, target);
    }
}
