class Solution {
    public String tree2str(TreeNode root) {
        // Base case: if the root is null, return an empty string
        if (root == null) return "";
        // Case for the leaf node
        if (root.right == null) {
            // If the left child is also null, return the root value as a string
            return root.val + (root.left == null ? "" : "(" + tree2str(root.left) + ")");
        }
        // Recursively build the string representation of the tree
        return root.val + "(" + tree2str(root.left) + ")(" + tree2str(root.right) + ")";
    }
}
