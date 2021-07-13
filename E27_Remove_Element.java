class Solution {
  public int removeElement(int[] nums, int val) {
    int count = 0;
    for (int num : nums) {
      if (val != num) {
        nums[count] = num;
        count++;
      }
    }
    return count;
  }
}
---------------------------------------------------------
