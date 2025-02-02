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
    private boolean res = true;
    public boolean isBalanced(TreeNode root) {
        check(root);
        return res;
    }
    public int check(TreeNode root) {
        if (root == null) return 0;
        int left = check(root.left);
        int right = check(root.right);
        if (Math.abs(left - right) > 1) res = false;
        return 1 + Math.max(left, right);
    }
}
