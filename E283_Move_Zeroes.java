class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                nums[index++] = nums[i];
        }
        
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
==========================================================
class Solution {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        for (int i = 0, j = 0; i < len && j < len; j++) {
            if (nums[j] != 0) {
                int temp = nums[i];
                nums[i++] = nums[j];
                nums[j] = temp;
            }

        }
    }
}
