public class Solution {
  public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if (nums[0] > lower) {
            res.add(lower + "->" + (nums[0] - 1));
            for (int i = 1; i < nums.length - 1; i++) {
                checkRange(nums, upper, res, i);
            }
        } else {
            for (int i = 0; i < nums.length - 1; i++) {
                checkRange(nums, upper, res, i);
            }
        }
        if (nums[nums.length - 1] < upper) {
            res.add(nums[nums.length - 1] + 1 + "->" + upper);
        }
        return res;
    }

    private static void checkRange(int[] nums, int upper, List<String> res, int i) {
        if (nums[i + 1] - nums[i] > 2 && nums[i] < upper) {
            int range = nums[i + 1] - 1;
            res.add(nums[i] + 1 + "->" + range);
        } else if (nums[i + 1] - nums[i] == 2) {
            int range = nums[i + 1] - 1;
            res.add(range + "");
        }
    }
}
