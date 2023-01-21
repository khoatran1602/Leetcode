class Solution {
    public boolean findTarget(TreeNode root, int k) {
        // Initialize a set to store the values of the nodes in the tree
        HashSet<Integer> set = new HashSet<>();
        // Call the helper method to perform the search
        return dfs(root, k, set);
    }

    private boolean dfs(TreeNode root, int k, HashSet<Integer> set) {
        // If the root is null, return false
        if (root == null) return false;
        // Check if the set contains the value k - root.val
        if (set.contains(k - root.val)) return true;
        // Add the value of the current node to the set
        set.add(root.val);
        // Perform the search on the left and right subtrees
        return dfs(root.left, k, set) || dfs(root.right, k, set);
    }
}

