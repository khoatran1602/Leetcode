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
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        int total = countEdges(root.left) + countEdges(root.right);
        return Math.max(total, Math.max(left, right));
    }

    public int countEdges(TreeNode root) {
        if (root == null) return 0;
        return Math.max(countEdges(root.left), countEdges(root.right)) + 1;
    }
}
