// class Solution {
//     public List<List<Integer>> subsets(int[] nums) {
//         List<List<Integer>> res = new ArrayList<>();
//         res.add(new ArrayList<>());
//         for (int i = 1; i <= nums.length; i++) {
//             helper(0, nums.length, new ArrayList<>(), res, i, nums);
//         }
//         return res;
//     }

//     public void helper(int start, int end, List<Integer> current, List<List<Integer>> res, int k, int[] nums) {
//         if (current.size() == k) {
//             res.add(new ArrayList<>(current));
//             return;
//         }
//         for (int i = start; i < nums.length; i++) {
//             current.add(nums[i]);
//             helper(i + 1, end, current, res, k, nums);
//             current.remove(current.size() - 1);
//         }
//     }
// }

class Solution {
    // Method to generate all possible subsets of an array of integers
    public List<List<Integer>> subsets(int[] nums) {
        // Create a new List to hold all possible subsets
        List<List<Integer>> subsets = new ArrayList<>();
        // Add the empty subset to the List
        subsets.add(new ArrayList<>());
        // Generate subsets of all sizes from 1 to the length of the input array
        for (int subsetSize = 1; subsetSize <= nums.length; subsetSize++) {
            generateSubsets(0, nums, new ArrayList<>(), subsets, subsetSize);
        }
        // Return the List of subsets
        return subsets;
    }

    // Recursive helper method to generate subsets of a given size
    public void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> subsets, int subsetSize) {
        // Base case: if the current List contains the desired number of elements, add it to the subsets List and return
        if (current.size() == subsetSize) {
            subsets.add(new ArrayList<>(current));
            return;
        }
        // Generate all possible subsets starting from the current index
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            // Recursively call the helper method to generate subsets with the next number
            generateSubsets(i + 1, nums, current, subsets, subsetSize);
            // Backtrack by removing the last number to try other subsets
            current.remove(current.size() - 1);
        }
    }
}
