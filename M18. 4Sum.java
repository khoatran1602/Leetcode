public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i == 0 || i > 0 && nums[i] != nums[i - 1]) {
                int end = nums.length - 1;
                while (i < end - 2) {
                    int index1 = i + 1;
                    int index2 = end - 1;
                    int s = nums[i] + nums[end];
                    if (s > target && nums[i] > 0 || s < target && nums[end] < 0) {
                        break;
                    }
                    while (index1 < index2) {
                        int sum = nums[index1] + nums[index2] + nums[i] + nums[end];
                        if (sum == target) {
                            List<Integer> list = new ArrayList<Integer>();
                            list.add(nums[i]);
                            list.add(nums[index1]);
                            list.add(nums[index2]);
                            list.add(nums[end]);
                            res.add(list);
                            while (nums[index2] == nums[index2 - 1] && index2 > index1) index2--;
                            index1++;
                            index2--;
                        } else if (sum < target) {
                            index1++;
                        } else {
                            index2--;
                        }
                    }
                    while (nums[end] == nums[end - 1] && i < end - 2) end--;
                    end--;

                }
            }
        }
        return res;
    }
}
