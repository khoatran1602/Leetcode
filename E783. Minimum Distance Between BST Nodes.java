class Solution {
    int minDiff = Integer.MAX_VALUE;
    int prev = -1;
    public int minDiffInBST(TreeNode root) {
        // Call the helper method inorder to traverse the tree
        inorder(root);
        return minDiff;
    }

    public void inorder(TreeNode root) {
        // If the root is null, return
        if (root == null) return;
        // Traverse the left subtree
        inorder(root.left);
        // Update the minimum difference if the current difference is smaller than the current minimum
        if (prev != -1) minDiff = Math.min(minDiff, root.val - prev);
        // Update the previous value
        prev = root.val;
        // Traverse the right subtree
        inorder(root.right);
    }
}
