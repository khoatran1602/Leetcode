/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

import java.util.Stack;

class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    public boolean hasPathSum_1(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && root.val == targetSum) return true;
        return hasPathSum_1(root.left, targetSum - root.val) || hasPathSum_1(root.right, targetSum - root.val);
    }

    public boolean hasPathSum_2(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        Stack<TreeNode> path = new Stack<>();
        Stack<Integer> sub = new Stack<>();
        path.push(root);
        sub.push(root.val);
        while (!path.isEmpty()) {
            TreeNode current = path.pop();
            int sum = sub.pop();
            if (current.left == null && current.right == null) {
                if (sum == targetSum)
                    return true;
            } else {
                if (current.left != null) {
                    path.push(current.left);
                    sub.push(current.left.val + sum);
                }
                if (current.right != null) {
                    path.push(current.right);
                    sub.push(current.right.val + sum);
                }
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode testTree = new TreeNode(5,
            new TreeNode(4,
                new TreeNode(11,
                    new TreeNode(7),
                    new TreeNode(2)),
                null),
            new TreeNode(8,
                new TreeNode(13),
                new TreeNode(4,
                    null,
                    new TreeNode(1))));
        System.out.println("Has path sum: " + solution.hasPathSum_1(testTree, 22));
        System.out.println("Has path sum: " + solution.hasPathSum_2(testTree, 22));
    }
}
