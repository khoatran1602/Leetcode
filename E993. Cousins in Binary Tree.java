class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return true;
        int depth = 0;
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int second = 0;
        findDepth(root, 0, list, x);
        findDepth(root, 0, list, y);
        if (list.get(1) == 1) return false;
        if (list.get(0) == list.get(1)) return true;
        return false;
    }

    public void findDepth(TreeNode root, int depth, List<Integer> list, int num) {
        if (root == null) return;
        if (root.val == num) {
            list.add(depth);
            list.add(depth + 1);
        }
        depth = depth + 1;
        findDepth(root.left, depth, list, num);
        findDepth(root.right, depth, list, num);
    }
}
