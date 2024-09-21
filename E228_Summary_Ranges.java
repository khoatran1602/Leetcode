import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums.length == 0) return list;
        if (nums.length == 1) {
            list.add(nums[0] + "");
        }
        int length = nums.length - 1;
        int first = 0;
        int last = 0;
        for (int i = 0; i < length; i++) {
            if ((nums[i] + 1) == nums[i+1]) {
                last++;
            } else {
                if (first != last) {
                    list.add(nums[first] + "->" + nums[last]);
                    last++;
                    first = last;
                } else {
                    list.add(nums[last] + "");
                    last++;
                    first = last;
                }
            }
            if (nums[i+1] == nums[length] && nums[i+1] != (nums[i] + 1)) list.add(nums[length] + "");
            else if (nums[i+1] == nums[length] && nums[i+1] == (nums[i] + 1)) {
                list.add(nums[first] + "->" + nums[last]);
            }
        }
        return list;
    }
}
