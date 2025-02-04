import java.util.Queue;

/**
 * LeetCode Problem 1302: Deepest Leaves Sum
 * 
 * This class provides a solution to find the sum of values of the deepest leaves 
 * in a binary tree using level-order traversal (BFS approach).
 * 
 * Time Complexity: O(N) where N is the number of nodes
 * Space Complexity: O(W) where W is the maximum width of the tree at any level
 */
class Solution {
    /**
     * Definition for a binary tree node.
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Calculates the sum of values of all leaves at the deepest level of the tree.
     * Uses level-order traversal to process the tree level by level, updating the sum
     * at each level. The final sum will represent the sum of the deepest leaves.
     * 
     * Example:
     *      1
     *     / \
     *    2   3
     *   / \   \
     *  4   5   6
     * /         \
     * 7          8
     * 
     * Deepest leaves are 7 and 8, so sum = 15
     * 
     * @param root The root node of the binary tree
     * @return The sum of values of the deepest leaves, 0 if tree is empty
     */
    public int deepestLeavesSum(TreeNode root) {
        if (root == null) return 0;

        // Initialize queue for level-order traversal
        Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.add(root);
        int sum = 0;

        // Process the tree level by level
        while (!queue.isEmpty()) {
            int nodesInCurrentLevel = queue.size();
            sum = 0;  // Reset sum for current level

            // Process all nodes at current level
            for (int i = 0; i < nodesInCurrentLevel; i++) {
                TreeNode currentNode = queue.poll();
                sum += currentNode.val;  // Add current node's value to level sum

                // Add children to queue for next level processing
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            // After the loop ends, sum will contain the values of the deepest level
        }

        return sum;
    }
    
    /**
     * Main method for testing the solution with example test cases
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case: Create a binary tree with multiple levels
        // Expected sum of deepest leaves (7 + 8) = 15
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(7);    // Deepest leaf
        root.right.right.right = new TreeNode(8); // Deepest leaf
        
        System.out.println("Sum of deepest leaves: " + 
                          solution.deepestLeavesSum(root)); // Expected: 15
    }
}
