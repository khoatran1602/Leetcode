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
    TreeNode node;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode check = new TreeNode(0);
        node = check;
        inorder(root);
        return check.right;
    }
    
    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        node.right = new TreeNode(root.val);
        node = node.right;
        inorder(root.right);
    }
}
