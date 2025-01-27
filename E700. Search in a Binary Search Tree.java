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
    public TreeNode searchBST(TreeNode root, int val) {
        // // If the root is null, return null
        // if (root == null) return null;
        // // Create a new TreeNode
        // TreeNode node = new TreeNode();
        // // Check if the root's value is equal to the target value
        // if (root.val == val) {
        //     // Assign the root's value and left/right children to the new node
        //     node = root;
        //     node.left = root.left;
        //     node.right = root.right;
        //     // Return the new node
        //     return node;
        // }
        // // Check if the target value is greater than the root's value
        // if (val > root.val) node = searchBST(root.right, val);
        // // If not, the target value must be less than the root's value
        // else node = searchBST(root.left, val);
        // // Return the new node
        // return node;
        
         // If the root is null, return null
        if (root == null) return null;
        // If the value of the root is equal to the target value, return the root
        if (root.val == val) return root;
        // If the target value is greater than the value of the root, search the right subtree
        if (val > root.val) return searchBST(root.right, val);
        // Otherwise, search the left subtree
        else return searchBST(root.left, val);
    } 
}
