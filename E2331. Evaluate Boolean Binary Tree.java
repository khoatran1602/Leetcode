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
    public boolean evaluateTree(TreeNode root) {
        if (root.val == 0) return false; // node value 0 means false
        if (root.val == 1) return true; // node value 1 means true
        boolean left = evaluateTree(root.left);  // evaluate left subtree
        boolean right = evaluateTree(root.right);  // evaluate right subtree
        if (root.val == 2) {  // node value 2 means logical OR
            return left || right;
        } else {  // node value 3 means logical AND
            return left && right;
        }
}
