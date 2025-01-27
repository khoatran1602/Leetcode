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
    public int sumOfLeftLeaves(TreeNode root) {
        return countLeft(root);
    }

    public int countLeft(TreeNode node) {
        if (node == null) return 0;
        int res = 0;
        if (node.left != null) {
            if (node.left.left == null && node.left.right == null) res = res + node.left.val;
            else res = res + countLeft(node.left);
        }
        res = res + countLeft(node.right);
        return res;
    }
}

