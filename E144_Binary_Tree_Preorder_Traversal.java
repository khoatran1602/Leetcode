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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        
        if (root == null) return result;
      
        result.add(root.val);
      
        left = preorderTraversal(root.left);
        right = preorderTraversal(root.right);
      
        result.addAll(left);
        result.addAll(right);
      
        return result;
    }
}
=======================================================================
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        return solve(root,l);
    }
    public List<Integer> solve(TreeNode root, List<Integer> list) {
        if(root == null) return list;
      
        list.add(root.val);
        solve(root.left, list);
        solve(root.right, list);
      
        return list;
    }
}
