class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
    }
    
    public static void main(String[] args) {
        // Test the solution
        Solution sol = new Solution();
        int[] nums = {3, 2, 1, 6, 0, 5};
        TreeNode root = sol.constructMaximumBinaryTree(nums);
        System.out.println(root.val); // 6
        System.out.println(root.left.val); // 3
        System.out.println(root.left.right.val); // 2
        System.out.println(root.left.right.right.val); // 1
        System.out.println(root.right.val); // 5
        System.out.println(root.right.left.val); // 0
    }
}
