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
    // Method to find the maximum width of a binary tree
    public int widthOfBinaryTree(TreeNode root) {
        // If the root is null, the tree has no width
        if (root == null) {
            return 0;
        }
        
        int maxWidth = 1; // Initialize the maximum width to 1 (the minimum possible value)
        Queue<TreeNode> queue = new LinkedList<>(); // Create a queue to hold the tree nodes
        Queue<Integer> indexQueue = new LinkedList<>(); // Create a queue to hold the indices of the nodes
        queue.offer(root); // Add the root node to the queue
        indexQueue.offer(1); // Add the index of the root node (1) to the index queue
        
        while (!queue.isEmpty()) { // While there are still nodes in the queue
            int levelSize = queue.size(); // Get the number of nodes in the current level
            int leftIndex = 0, rightIndex = 0; // Initialize the indices of the leftmost and rightmost nodes in the current level
            
            for (int i = 0; i < levelSize; i++) { // Loop through all the nodes in the current level
                TreeNode node = queue.poll(); // Get the next node in the queue
                int index = indexQueue.poll(); // Get the index of the node
                
                if (i == 0) { // If this is the first node in the level, set its index as the leftmost index
                    leftIndex = index;
                }
                if (i == levelSize - 1) { // If this is the last node in the level, set its index as the rightmost index
                    rightIndex = index;
                }
                
                if (node.left != null) { // If the node has a left child, add it to the queue and set its index as index*2
                    queue.offer(node.left);
                    indexQueue.offer(index * 2);
                }
                if (node.right != null) { // If the node has a right child, add it to the queue and set its index as index*2+1
                    queue.offer(node.right);
                    indexQueue.offer(index * 2 + 1);
                }
            }
            
            maxWidth = Math.max(maxWidth, rightIndex - leftIndex + 1); // Update the maximum width based on the indices of the leftmost and rightmost nodes in the current level
        }
        
        return maxWidth; // Return the maximum width of the tree
    }
}
