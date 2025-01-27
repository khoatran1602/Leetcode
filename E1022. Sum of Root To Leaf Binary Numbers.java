/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // Entry point method to calculate the sum of all binary numbers formed from root to leaf paths
    public int sumRootToLeaf(TreeNode root) {
        // Call helper method to traverse the binary tree and calculate the sum
        return dfs(root, 0);
    }

    // Helper method to traverse the binary tree using DFS
    public int dfs(TreeNode root, int val) {
        // Base case: if root is null, return 0
        if (root == null) return 0;
        // Multiply the current value by 2 and add root's value
        val = val * 2 + root.val;
        // If root is a leaf node, return the current value
        if (root.left == null && root.right == null) return val;
        // Otherwise, recursively call the helper method on the left and right children and return their sum
        return dfs(root.left, val) + dfs(root.right, val);
    }
}
