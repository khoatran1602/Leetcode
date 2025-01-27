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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root != null) generatePath(root, "", res);
        return res;
        
    }
    public void generatePath(TreeNode node, String path, List<String> res) {
        if (node.left == null && node.right == null) res.add(path + node.val);
        if (node.left != null) generatePath(node.left, path + node.val + "->", res);
        if (node.right != null) generatePath(node.right, path + node.val + "->", res);
    }
}
