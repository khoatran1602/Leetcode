class Solution {
    public boolean isUnivalTree(TreeNode root) {
        // return true if root is null
        if (root == null) return true;
        // return result of checkBool method
        return checkBool(root, root.val);
    }

    public boolean checkBool(TreeNode root, int val) {
        // return true if root is null
        if (root == null) return true;
        // return true if the value of root is equal to given value and both left and right subtrees are unival trees
        return root.val == val && checkBool(root.left, val) && checkBool(root.right, val);
    }
}
