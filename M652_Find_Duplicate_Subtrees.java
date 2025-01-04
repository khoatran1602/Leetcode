import java.util.ArrayList;
import java.util.List;
import java.util.*;

/**
 * Solution for LeetCode 652: Find Duplicate Subtrees
 * Problem: Find all duplicate subtrees in a binary tree
 */
class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
        
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Finds all duplicate subtrees in the given binary tree
     * @param root root of the binary tree
     * @return list of root nodes of all duplicate subtrees
     */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        // List to store nodes that are roots of duplicate subtrees
        List<TreeNode> result = new ArrayList<>();
        // Map to store serialized subtree representation and its frequency
        Map<String, Integer> subtreeMap = new HashMap<>();
        // Perform post-order traversal to build subtree representations
        serializeSubtrees(root, subtreeMap, result);
        return result;
    }

    /**
     * Serializes subtrees using post-order traversal and identifies duplicates
     * @param node current node being processed
     * @param subtreeMap map storing subtree representations and frequencies
     * @param result list to store duplicate subtree roots
     * @return serialized representation of the current subtree
     */
    private String serializeSubtrees(TreeNode node, Map<String, Integer> subtreeMap, List<TreeNode> result) {
        // Base case: null node represented as "#"
        if (node == null) return "#";

        // Build unique string representation using post-order traversal
        String serialized = node.val + "," + 
                          serializeSubtrees(node.left, subtreeMap, result) + "," +
                          serializeSubtrees(node.right, subtreeMap, result);

        // Update frequency in map
        subtreeMap.put(serialized, subtreeMap.getOrDefault(serialized, 0) + 1);
        
        // If this is the second time we've seen this subtree, add to result
        if (subtreeMap.get(serialized) == 2) {
            result.add(node);
        }

        return serialized;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(4);
        System.out.println(sol.findDuplicateSubtrees(root));
    }
}