import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode Problem 662: Maximum Width of Binary Tree
 * Width is defined as the length between the leftmost and rightmost non-null nodes in a level.
 */
class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * Calculates the maximum width of a binary tree
     * @param root The root node of the binary tree
     * @return The maximum width found in the tree
     */
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int maximumWidth = 1;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> positionQueue = new LinkedList<>();

        nodeQueue.offer(root);
        positionQueue.offer(1);

        while (!nodeQueue.isEmpty()) {
            int nodesInCurrentLevel = nodeQueue.size();
            int leftmostPosition = 0;
            int rightmostPosition = 0;

            for (int nodeIdx = 0; nodeIdx < nodesInCurrentLevel; nodeIdx++) {
                TreeNode currentNode = nodeQueue.poll();
                int currentPosition = positionQueue.poll();

                if (nodeIdx == 0) {
                    leftmostPosition = currentPosition;
                }
                if (nodeIdx == nodesInCurrentLevel - 1) {
                    rightmostPosition = currentPosition;
                }

                if (currentNode.left != null) {
                    nodeQueue.offer(currentNode.left);
                    positionQueue.offer(currentPosition * 2);
                }
                if (currentNode.right != null) {
                    nodeQueue.offer(currentNode.right);
                    positionQueue.offer(currentPosition * 2 + 1);
                }
            }

            int currentLevelWidth = rightmostPosition - leftmostPosition + 1;
            maximumWidth = Math.max(maximumWidth, currentLevelWidth);
        }

        return maximumWidth;
    }

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
