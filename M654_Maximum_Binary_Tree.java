/**
 * LeetCode #654 - Maximum Binary Tree
 * 
 * Problem: Given an integer array nums, construct a maximum binary tree where:
 * 1. The root is the maximum number in the array
 * 2. The left subtree is the maximum tree constructed from left part subarray
 * 3. The right subtree is the maximum tree constructed from right part subarray
 */
class Solution {
    /**
     * Definition for a binary tree node.
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    
    /**
     * Constructs a maximum binary tree from the given array.
     * 
     * @param nums Input array of integers
     * @return Root node of the constructed maximum binary tree
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // Handle edge cases
        if (nums == null || nums.length == 0) return null;
        return buildTree(nums, 0, nums.length - 1);
    }
    
    /**
     * Recursively builds the maximum binary tree.
     * 
     * @param nums Input array
     * @param start Start index of current subarray
     * @param end End index of current subarray
     * @return Root node of the current subtree
     */
    private TreeNode buildTree(int[] nums, int start, int end) {
        // Base case: invalid range
        if (start > end) return null;
        
        // Find the maximum element and its index in current range
        int maxIndex = findMaxIndex(nums, start, end);
        
        // Create root node with maximum value
        TreeNode root = new TreeNode(nums[maxIndex]);
        
        // Recursively construct left and right subtrees
        root.left = buildTree(nums, start, maxIndex - 1);
        root.right = buildTree(nums, maxIndex + 1, end);
        
        return root;
    }

    /**
     * Finds the index of maximum element in the given range.
     * 
     * @param nums Input array
     * @param start Start index
     * @param end End index
     * @return Index of the maximum element
     */
    private int findMaxIndex(int[] nums, int start, int end) {
        int maxIndex = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    
    public static void main(String[] args) {
        // Test case with example array [3,2,1,6,0,5]
        Solution sol = new Solution();
        int[] nums = {3, 2, 1, 6, 0, 5};
        
        TreeNode root = sol.constructMaximumBinaryTree(nums);
        
        // Print tree values in expected order
        System.out.println("Root value: " + root.val);                    // Expected: 6
        System.out.println("Left child: " + root.left.val);              // Expected: 3
        System.out.println("Left-right child: " + root.left.right.val);  // Expected: 2
        System.out.println("Left-right-right: " + root.left.right.right.val); // Expected: 1
        System.out.println("Right child: " + root.right.val);            // Expected: 5
        System.out.println("Right-left child: " + root.right.left.val);  // Expected: 0
    }
}
