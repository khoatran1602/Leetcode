class Solution {
    // Entry point method that checks if a given binary tree is a subtree of another binary tree
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // Base case: if root is null, return false
        if (root == null) return false;
        // If current node is equal to the subtree's root, and the subtrees are identical
        if (root.val == subRoot.val && checkEqual(root, subRoot)) {
            return true;
        }
        // Recursively check the left and right subtrees for the subtree
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // Helper method that checks if two binary trees are identical
    public boolean checkEqual(TreeNode root, TreeNode subRoot) {
        // Base case: if both root and subRoot are null, return true
        if (root == null && subRoot == null) return true;
        // Base case: if one of root or subRoot is null or their values are not equal, return false
        if (root == null || subRoot == null || root.val != subRoot.val) return false;
        // Recursively check the left and right subtrees
        return checkEqual(root.left, subRoot.left) && checkEqual(root.right, subRoot.right);
    }
}
