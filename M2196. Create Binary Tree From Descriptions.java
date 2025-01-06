import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Solution for LeetCode 2196: Create Binary Tree From Descriptions
 * This class constructs a binary tree from a given array of descriptions,
 * where each description contains [parent, child, isLeft] information.
 */
class Solution {
    /**
     * Definition for a binary tree node.
     * Each node contains a value and references to left and right children.
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            val = value;
        }
    }
    
    /**
     * Creates a binary tree from an array of node descriptions.
     * @param descriptions Array of [parent, child, isLeft] entries
     * @return Root node of the constructed binary tree
     */
    public TreeNode createBinaryTree(int[][] descriptions) {
        // Map to store node values to their corresponding TreeNode objects
        HashMap<Integer, TreeNode> nodeMap = new HashMap<>();
        // Track all nodes that are children (to help find root later)
        Set<Integer> childNodes = new HashSet<>();
        
        // Build the tree structure from descriptions
        for (int[] description : descriptions) {
            int parentValue = description[0];
            int childValue = description[1];
            boolean isLeftChild = description[2] == 1;
            
            // Record this node as a child
            childNodes.add(childValue);
            
            // Get or create parent and child nodes
            TreeNode parentNode = nodeMap.getOrDefault(parentValue, new TreeNode(parentValue));
            TreeNode childNode = nodeMap.getOrDefault(childValue, new TreeNode(childValue));
            
            // Connect child to parent based on isLeftChild flag
            if (isLeftChild) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }
            
            // Update the node map with both nodes
            nodeMap.put(parentValue, parentNode);
            nodeMap.put(childValue, childNode);
        }
        
        // Find the root (the only parent that is not someone else's child)
        int rootValue = -1;
        for (int[] description : descriptions) {
            if (!childNodes.contains(description[0])) {
                rootValue = description[0];
                break;
            }
        }
        
        // Return the root node of the constructed tree
        return nodeMap.getOrDefault(rootValue, null);
    }
}
