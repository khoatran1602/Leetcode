class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> firstNum = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (!firstNum.contains(nums[i])) {
                Set<Integer> secondNum = new HashSet<>();
                Set<Integer> thirdNum = new HashSet<>();
                for (int j = i + 1; j < nums.length; j++) {
                    if (!firstNum.contains(nums[j]) && !thirdNum.contains(nums[j])) {
                        if (secondNum.contains(-nums[i] - nums[j])) { //-nums[i] - nums[j] becuase a + b + c = 0 => c = - a - b
                            res.add(Arrays.asList(nums[i], nums[j], -nums[i] - nums[j]));
                            thirdNum.add(nums[j]);
                        } else {
                            secondNum.add(nums[j]);
                        }
                    }
                }
                firstNum.add((nums[i]));
            }
        }
        return res;
    } 
}
