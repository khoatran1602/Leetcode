class Solution {
    // Entry point method to check if two nodes in a binary tree are cousins
    public boolean isCousins(TreeNode root, int x, int y) {
        // Variables to store parent and depth of node x and y
        int[] parentX = {0};
        int[] parentY = {0};
        int[] depthX = {-1};
        int[] depthY = {-1};
        // Call helper method to find the depth and parent of node x
        findDepth(root, null, parentX, depthX, 0, x);
        // Call helper method to find the depth and parent of node y
        findDepth(root, null, parentY, depthY, 0, y);
        // Return true if both nodes have the same depth and different parents
        return depthX[0] == depthY[0] && parentX[0] != parentY[0];
    }

    // Helper method to find depth and parent of a node in a binary tree
    public void findDepth(TreeNode root, TreeNode parent, int[] parentNode, int[] depthNode, int depth, int num) {
        // Base case: if root is null, return
        if (root == null) return;
        // If root's value is equal to num, update parentNode and depthNode
        if (root.val == num) {
            depthNode[0] = depth;
            parentNode[0] = parent != null ? parent.val : 0;
        }
        // Recursively call the helper method on left and right children
        findDepth(root.left, root, parentNode, depthNode, depth + 1, num);
        findDepth(root.right, root, parentNode, depthNode, depth + 1, num);
    }
}
