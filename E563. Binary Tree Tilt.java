class Solution {
    // Entry point method to find the tilt of a binary tree
    public int findTilt(TreeNode root) {
        // Base case: if root is null, return 0
        if (root == null) return 0;
        // Recursively find tilt(absolute differences between the sum of the values in its left subtree) of left subtree
        int left = findTilt(root.left);
        // Recursively find tilt(absolute differences between the sum of the values in its right subtree) of right subtree
        int right = findTilt(root.right);
        // Initialize variable to store tilt of current tree
        int sum = 0;
        // Add the tilt of left and right subtrees to the tilt of current tree
        return left + right + Math.abs(getAmount(root.left) - getAmount(root.right));
    }

    // Helper method to find the sum of all the nodes in a subtree
    public int getAmount(TreeNode root) {
        // Base case: if root is null, return 0
        if (root == null) return 0;
        // Recursively find the sum of left and right subtrees and add the value of current node
        return root.val + getAmount(root.left) + getAmount(root.right);
    }
}
