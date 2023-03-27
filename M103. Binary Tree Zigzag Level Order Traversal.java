class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>(); // the final zigzag level order traversal
        if (root == null) return result; // if the tree is empty, return an empty traversal
        Queue<TreeNode> queue = new LinkedList<>(); // queue to keep track of the nodes in the current level
        int level = 0; // current level of the tree
        queue.add(root); // add the root node to the queue
        while (!queue.isEmpty()) {
            int size = queue.size(); // number of nodes in the current level
            List<Integer> levelTraversal = new ArrayList<>(); // list to keep track of the nodes in the current level
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll(); // get the next node in the level from the queue
                levelTraversal.add(curr.val); // add the node value to the levelTraversal list
                if (curr.left != null) {
                    queue.add(curr.left); // add the left child to the queue
                }
                if (curr.right != null) {
                    queue.add(curr.right); // add the right child to the queue
                }
            }
            if (level % 2 == 1) { // if the level is odd, reverse the order of the nodes in the levelTraversal list
                Collections.reverse(levelTraversal);
            }
            result.add(levelTraversal); // add the levelTraversal list to the result list
            level++; // increment the level counter
        }
        return result;
    }
}
