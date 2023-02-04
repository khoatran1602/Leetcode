class Solution {
    public boolean checkTree(TreeNode root) {
        // Check if the tree is empty
        if (root == null) return true;        
        // Get the sum of the leaves in the tree
        int sum = sumLeaves(root);        
        // Check if the sum of the leaves equals the value of the root node
        return sum == root.val;
    }

    public int sumLeaves(TreeNode node) {
        // Check if the node is null
        if (node == null) return 0;        
        // Check if the node is a leaf node
        if (node.left == null && node.right == null) return node.val;
        // Add up the sum of the leaves in the left and right subtrees
        return sumLeaves(node.left) + sumLeaves(node.right);
    }
}
