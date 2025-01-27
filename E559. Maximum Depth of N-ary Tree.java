/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        // Base case: if the root is null, return 0
        if (root == null) return 0;
        
        // Initialize a variable to store the maximum depth
        int max = 0;
        // Iterate through all the children of the current node
        for (Node child : root.children) {
            // Compare the current maximum depth to the depth of the current child
            max = Math.max(max, maxDepth(child));
        }
        
        // Return the maximum depth among all the children's depths + 1 (to account for the current level)
        return max + 1;
    }
}


