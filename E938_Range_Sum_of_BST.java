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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        int sum = 0;
        if (root.val >= low && root.val <= high) sum = root.val;
        // if root is below low, its left numbers(lower numbers) will definitely be out of range
        if (root.val >= low) sum = sum + rangeSumBST(root.left, low, high);
        // if root is above high range, its right numbers(higher numbers) will definitely be out of range
        if (root.val <= high) sum = sum + rangeSumBST(root.right, low, high);
        return sum;
    }
}
