import java.util.HashSet;
import java.util.Set;

/**
 * Solution for LeetCode 653: Two Sum IV - Input is a BST
 * Time Complexity: O(n) where n is the number of nodes
 * Space Complexity: O(n) to store the hash set
 */
class TwoSumIVSolution {
    /**
     * Finds if there exist two elements in the BST that sum to the target.
     * @param root The root node of the BST
     * @param target The target sum
     * @return true if two different nodes sum to target, false otherwise
     */
    public boolean findTarget(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        return findPairSum(root, target, new HashSet<>());
    }
    
    /**
     * Helper method that uses a hash set to find pair sum in the BST.
     */
    private boolean findPairSum(TreeNode node, int target, Set<Integer> seen) {
        if (node == null) {
            return false;
        }

        // Check if we've seen the complement value
        if (seen.contains(target - node.val)) {
            return true;
        }

        // Add current value to seen set
        seen.add(node.val);

        // Check both subtrees
        return findPairSum(node.left, target, seen) ||
                findPairSum(node.right, target, seen);
    }
    
    public static void main(String[] args) {
        // Create a BST
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        // Test the solution
        TwoSumIVSolution sol = new TwoSumIVSolution();
        System.out.println(sol.findTarget(root, 9)); // true
        System.out.println(sol.findTarget(root, 28)); // false
    }
}
