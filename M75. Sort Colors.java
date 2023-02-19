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

class Solution {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        for (int i = 0; i <= right; i++) {
            if (nums[i] == 0) {  // if current element is 0
                nums[i] = nums[left];  // move it to the left
                nums[left++] = 0;  // and move the left pointer to the right
            } else if (nums[i] == 2) {  // if current element is 2
                nums[i--] = nums[right];  // move it to the right
                nums[right--] = 2;  // and move the right pointer to the left
            }
        }
    }
}

