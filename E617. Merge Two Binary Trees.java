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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // Base case: if the first tree is null, return the second tree
        if (root1 == null) return root2;
        // Base case: if the second tree is null, return the first tree
        if (root2 == null) return root1;
        // Add the values of the corresponding nodes of the two trees
        root1.val += root2.val;
        // Recursively merge the left subtrees
        root1.left = mergeTrees(root1.left, root2.left);
        // Recursively merge the right subtrees
        root1.right = mergeTrees(root1.right, root2.right);
        // Return the modified first tree
        return root1;
    }
}
