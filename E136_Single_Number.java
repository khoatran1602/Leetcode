class Solution {
    public int singleNumber(int[] nums) {
        int length = nums.length;
        int count = 0;
        HashMap<Integer, Integer> newNums = new HashMap<>();
        if (length == 1) {
            System.out.println(nums[0]);
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (nums[j] == nums[i]) {
                    count++;
                }
            }
            newNums.put(count, nums[i]);
            count = 0;
        }
        return newNums.get(1);
    }
}
-----------------------------------------------------------------------
class Solution {
  public int singleNumber(int[] nums) {
     int num = 0;
      for(int i = 0;i < nums.length; i++){
          num ^= nums[i];
      }
      return num;
  }
}
