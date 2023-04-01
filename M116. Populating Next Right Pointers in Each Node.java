class Solution {
    public Node connect(Node root) {
        if (root == null) return null; // base case: return null if root is null
        Node leftSubtree = root.left; // get the left subtree of the root
        Node rightSubtree = root.right; // get the right subtree of the root
        while (leftSubtree != null) {
            leftSubtree.next = rightSubtree; // connect the left subtree's next node to the right subtree
            leftSubtree = leftSubtree.right; // move to the next node on the right of the left subtree
            rightSubtree = rightSubtree.next; // move to the next node on the left of the right subtree
        }
        connect(root.left); // recursively connect the left subtree
        connect(root.right); // recursively connect the right subtree
        return root; // return the connected tree
    }
}
