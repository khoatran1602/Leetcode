import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int[] findErrorNums(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= nums.length; i++) {
            map.put(i, 0);
        }
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.get(nums[i]) + 1);
        }
        int[] result = new int[2];
        for (int i = 1; i <= nums.length; i++) {
            if (map.get(i) == 2) {
                result[0] = i;
            }
            if (map.get(i) == 0) {
                result[1] = i;
            }
        }
        return result;
    }

    public void main(String[] args) {
        int[] nums = {1, 2, 2, 4};
        int[] result = findErrorNums(nums);
        System.out.println(result[0] + " " + result[1]);
    }
}