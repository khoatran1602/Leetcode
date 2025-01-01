

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    
    public TreeNode createBinaryTree(int[][] descriptions) {
        // Create a map to store nodes and their parent-child relationships
        HashMap<Integer, TreeNode> map = new HashMap<>();
        // Create a set to keep track of all the child nodes
        Set<Integer> children = new HashSet<>();
        
        // Loop through each description in the input array
        for (int[] arr : descriptions) {
            // Extract parent, child, and whether child is left or right from the current description
            int parent = arr[0], child = arr[1], isLeft = arr[2];
            // Add child to the set of children
            children.add(child);
            // Get the parent node from the map, or create a new node if it doesn't exist
            TreeNode node = map.getOrDefault(parent, new TreeNode(parent));
            // Set the child node as the left or right child of the parent node, depending on isLeft
            if (isLeft == 1) {
                node.left = map.getOrDefault(child, new TreeNode(child));
                map.put(child, node.left);
            } else {
                node.right = map.getOrDefault(child, new TreeNode(child));
                map.put(child, node.right);
            }
            // Update the parent node in the map
            map.put(parent, node);
        }
        
        // Find the root node of the tree by looking for a node that is not a child of any other node
        int root = -1;
        for (int [] arr: descriptions) {
            if (!children.contains(arr[0])) {
                root = arr[0];
                break;
            }
        }
        
        // Return the root node, or null if it doesn't exist
        return map.getOrDefault(root, null);
    }
}
