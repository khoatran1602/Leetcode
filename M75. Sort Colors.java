class Solution {
    public void sortColors(int[] nums) {
        Arrays.sort(nums);
    }
}

class Solution {
    public void sortColors(int[] nums) {
        int[] newNums = new int[nums.length];
        int index = 0;
        for (int num : nums) {
            if (num == 0) {
                newNums[index++] = num;
            }
        }
        for (int num : nums) {
            if (num == 1) {
                newNums[index++] = num;
            }
        }
        for (int num : nums) {
            if (num == 2) {
                newNums[index++] = num;
            }
        }
        int count = 0;
        for (int i = 0; i < newNums.length; i++) {
            nums[i] = newNums[i];
        }
    }
}
