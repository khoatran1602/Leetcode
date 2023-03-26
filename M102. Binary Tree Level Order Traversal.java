class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> traversal = new ArrayList<>();
        
        // Return an empty list if the root is null
        if (root == null) {
            return traversal;
        }
        
        // Use a queue to store nodes in breadth-first order
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            
            // Process nodes in the current level
            for (int i = 0; i < levelSize; i++) {
                // Get the current node and add its value to the level list
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);
                
                // Add the left and right child of the current node to the queue
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            
            // Add the current level to the traversal list
            traversal.add(currentLevel);
        }
        
        return traversal;
    }
}
