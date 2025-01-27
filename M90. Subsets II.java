class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // sort the input array
        Arrays.sort(nums);
        // initialize an empty list to store all subsets
        List<List<Integer>> subsets = new ArrayList<>();
        // call the recursive helper function
        generateSubsets(0, nums, subsets, new ArrayList<>());
        // return the list of subsets
        return subsets;
    }

    // recursive function to generate all subsets
    public static void generateSubsets(int index, int[] nums, List<List<Integer>> subsets, List<Integer> currentSubset) {
        // add the current subset to the list of subsets
        subsets.add(new ArrayList<>(currentSubset));
        // iterate through the array starting from the current index
        for (int i = index; i < nums.length; i++) {
            // if the current element is a duplicate, skip it
            if (i != index && nums[i] == nums[i - 1]) continue;
            // add the current element to the current subset
            currentSubset.add(nums[i]);
            // recursively generate subsets starting from the next index
            generateSubsets(i + 1, nums, subsets, currentSubset);
            // remove the current element from the current subset
            currentSubset.remove(currentSubset.size() - 1);
        }
    }
}
