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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Base case: if the preorder array has only one element, return a new tree node with that element as its value
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        // Base case: if the preorder array is empty, return null
        if (preorder.length == 0) {
            return null;
        }
        // Create the root node of the tree using the first element in the preorder array
        TreeNode root = new TreeNode(preorder[0]);
        // Find the index of the root node in the inorder array
        int rootIndexInInorder = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                rootIndexInInorder = i;
                break;
            }
        }
        // Split the preorder and inorder arrays into left and right subtrees based on the position of the root node
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, rootIndexInInorder + 1);
        int[] rightPreorder = Arrays.copyOfRange(preorder, rootIndexInInorder + 1, preorder.length);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, rootIndexInInorder);
        int[] rightInorder = Arrays.copyOfRange(inorder, rootIndexInInorder + 1, inorder.length);
        // Recursively build the left and right subtrees and attach them to the root node
        root.left = buildTree(leftPreorder, leftInorder);
        root.right = buildTree(rightPreorder, rightInorder);
        return root;
    }
}
