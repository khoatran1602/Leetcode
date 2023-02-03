class Solution {
    // Returns a copy of the target node in the cloned tree
    public TreeNode getTargetCopy(TreeNode original, TreeNode cloned, TreeNode target) {
        // if original tree is empty, return null
        if (original == null) return null;
        // if original node is equal to target node, return the cloned node
        if (original == target) return cloned;
        // check if target is in the left subtree of original
        TreeNode leftResult = getTargetCopy(original.left, cloned.left, target);
        // if target is found in the left subtree, return it
        if (leftResult != null) return leftResult;
        // target not found in the left, check right subtree
        return getTargetCopy(original.right, cloned.right, target);
    }
}
