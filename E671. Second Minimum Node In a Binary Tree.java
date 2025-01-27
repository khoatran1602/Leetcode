class Solution {
    public int dfs(TreeNode root, int min) {
        // If the root is null, return -1
        if (root == null) return -1;
        // If the value of the root is greater than min, return it
        if (root.val > min) return root.val;
        // Perform the search on the left and right subtrees
        int left = dfs(root.left, min);
        int right = dfs(root.right, min);
        // Return the minimum value of the left and right subtrees
        return (left == -1 || right == -1) ? Math.max(left, right) : Math.min(left, right);
    }
    public int findSecondMinimumValue(TreeNode root) {
        // If the root is null, return -1
        if (root == null) return -1;
        // Call the helper method to perform the search
        return dfs(root, root.val);
    }
}
