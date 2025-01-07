import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Solution for LeetCode 655: Print Binary Tree
 * This class provides a solution to print a binary tree in a 2D string matrix format
 */
class Solution {
    /**
     * TreeNode class representing each node in the binary tree
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
     * Prints the binary tree in a 2D matrix format
     * @param root The root node of the binary tree
     * @return List of lists containing the binary tree representation
     */
    public List<List<String>> printTree(TreeNode root) {
        // Step 1: Calculate dimensions
        int height = getHeight(root);
        int width = (int)Math.pow(2, height) - 1;
        
        // Step 2: Initialize the result matrix
        String[][] res = new String[height][width];
        for (String[] arr : res) {
            Arrays.fill(arr, "");
        }
            
        // Step 3: Recursively fill the matrix with tree values
        fill(root, res, 0, 0, width - 1);
        
        // Step 4: Convert array to List format
        List<List<String>> ans = new ArrayList<>();
        for (String[] arr : res) {
            ans.add(Arrays.asList(arr));
        }
            
        return ans;
    }
    
    /**
     * Calculates the height of the binary tree
     * @param root The root node of the tree/subtree
     * @return The height of the tree (1-based)
     */
    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
    
    /**
     * Recursively fills the matrix with tree values in the correct positions
     * @param root Current tree node
     * @param res Result matrix to fill
     * @param row Current row in the matrix
     * @param left Leftmost index of current valid segment
     * @param right Rightmost index of current valid segment
     */
    private void fill(TreeNode root, String[][] res, int row, int left, int right) {
        if (root == null) {
            return;
        }
        
        // Calculate middle position for current node
        int mid = left + (right - left) / 2;
        res[row][mid] = String.valueOf(root.val);
        
        // Recursively fill left and right subtrees
        fill(root.left, res, row + 1, left, mid - 1);
        fill(root.right, res, row + 1, mid + 1, right);
    }
    
    /**
     * Main method for testing the solution
     */
    public static void main(String[] args) {
        // Create test tree and solution instance
        Solution sol = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        
        // Print result
        System.out.println(sol.printTree(root));
    }
}