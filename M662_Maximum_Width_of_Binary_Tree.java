import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode Problem 662: Maximum Width of Binary Tree
 * 
 * This class provides a solution to find the maximum width of a binary tree.
 * The width is defined as the length between the leftmost and rightmost non-null nodes 
 * at each level, where null nodes between the ends are also counted.
 * 
 * Time Complexity: O(N) where N is the number of nodes
 * Space Complexity: O(W) where W is the maximum width of the tree
 */
class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * Calculates the maximum width of a binary tree using level-order traversal.
     * The position of each node is calculated using 2n for left child and 2n+1 for right child,
     * where n is the position of the parent node.
     * 
     * Example:
     *     1
     *    / \
     *   3   2
     *  / \   \
     * 5   3   9
     * Maximum width = 3 (nodes 5, 3, and 9 at the lowest level)
     * 
     * @param root The root node of the binary tree
     * @return The maximum width found in the tree, or 0 if the tree is empty
     */
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        // Initialize queues for level-order traversal
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> positionQueue = new LinkedList<>();
        int maximumWidth = 1;  // Minimum width is 1 for a non-empty tree

        // Start with root node at position 1
        nodeQueue.offer(root);
        positionQueue.offer(1);

        while (!nodeQueue.isEmpty()) {
            int nodesInCurrentLevel = nodeQueue.size();
            int leftmostPosition = 0;
            int rightmostPosition = 0;

            // Process all nodes at current level
            for (int nodeIdx = 0; nodeIdx < nodesInCurrentLevel; nodeIdx++) {
                TreeNode currentNode = nodeQueue.poll();
                int currentPosition = positionQueue.poll();

                // Track the positions of leftmost and rightmost nodes
                if (nodeIdx == 0) {
                    leftmostPosition = currentPosition;
                }
                if (nodeIdx == nodesInCurrentLevel - 1) {
                    rightmostPosition = currentPosition;
                }

                // Add children to queue with their calculated positions
                // Left child position = 2 * parent position
                if (currentNode.left != null) {
                    nodeQueue.offer(currentNode.left);
                    positionQueue.offer(currentPosition * 2);
                }
                // Right child position = 2 * parent position + 1
                if (currentNode.right != null) {
                    nodeQueue.offer(currentNode.right);
                    positionQueue.offer(currentPosition * 2 + 1);
                }
            }

            // Update maximum width if current level is wider
            int currentLevelWidth = rightmostPosition - leftmostPosition + 1;
            maximumWidth = Math.max(maximumWidth, currentLevelWidth);
        }

        return maximumWidth;
    }

    /**
     * Main method for testing the solution with example test cases
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Binary tree with maximum width of 3
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        System.out.println(solution.widthOfBinaryTree(root));  // Expected: 3

        // Test case 2: Binary tree with maximum width of 4
        root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        root.left.left.left = new TreeNode(6);
        root.right.right.right = new TreeNode(7);
        System.out.println(solution.widthOfBinaryTree(root));  // Expected: 4
    }
}
