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
    // Initialize three tree nodes to keep track of previous, first, and second nodes
    TreeNode previousNode = null;
    TreeNode firstIncorrectNode = null;
    TreeNode secondIncorrectNode = null;

    // Traverse the binary search tree inorder and update the nodes accordingly
    void traverseInorder(TreeNode currentNode) {
        // Base case: if the current node is null, return
        if (currentNode == null) {
            return;
        }
        // Traverse left subtree
        traverseInorder(currentNode.left);
        // Check if current node is less than the previous node
        if (previousNode != null && currentNode.val < previousNode.val) {
            // Update first and second incorrect nodes accordingly
            if (firstIncorrectNode == null) {
                firstIncorrectNode = previousNode;
            }
            secondIncorrectNode = currentNode;
        }
        // Update the previous node to the current node
        previousNode = currentNode;
        // Traverse right subtree
        traverseInorder(currentNode.right);
    }

    // Recover the binary search tree by swapping the two incorrect nodes
    public void recoverTree(TreeNode root) {
        // Base case: if the root is null, return
        if (root == null) {
            return;
        }
        // Traverse the binary search tree inorder and update the incorrect nodes
        traverseInorder(root);
        // Swap the values of the two incorrect nodes to recover the binary search tree
        int tempValue = firstIncorrectNode.val;
        firstIncorrectNode.val = secondIncorrectNode.val;
        secondIncorrectNode.val = tempValue;
    }
}

