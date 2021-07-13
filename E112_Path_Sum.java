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
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        Stack<TreeNode> path = new Stack<>();
        Stack<Integer> sub = new Stack<>();
        path.push(root);
        sub.push(root.val);
        while (!path.isEmpty()) {
            TreeNode current = path.pop();
            int sum = sub.pop();
            if (current.left == null && current.right == null) {
                if (sum == targetSum) return true;
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
    }
    return false;
  }
}
------------------------------------------------------------------------
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && root.val == targetSum) return true;
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
