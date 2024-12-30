import java.util.Map;
import java.util.HashMap;

class Solution {
  public static int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], i);
    }
    for (int i = 0; i < nums.length; i++) {
      int foundNumber = target - nums[i];
      if (map.containsKey(foundNumber) && map.get(foundNumber) != i) {
        return new int[] { i, map.get(foundNumber) };
      }
    }
    throw new IllegalArgumentException("No two sum solution");
  }
  
  public static void main(String[] args) {
    int[] nums = {2, 7, 11, 15};
    int target = 9;
    int[] result = twoSum(nums, target);
    System.out.println(result[0] + " " + result[1]);
  }
}