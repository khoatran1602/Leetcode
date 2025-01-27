class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        // Initialize a list to store the averages of each level
        List<Double> result = new ArrayList<>();
        // Initialize a queue to store the nodes at each level
        Queue<TreeNode> queue = new LinkedList<>();
        // If the root is null, return an empty list
        if (root == null) return result;
        // Add the root to the queue
        queue.offer(root);
        // Loop while the queue is not empty
        while (!queue.isEmpty()) {
            // Get the size of the queue
            int size = queue.size();
            // Initialize a variable to store the sum of the values of the nodes at the current level
            double sum = 0;
            // Loop for the size of the queue
            for (int i = 0; i < size; i++) {
                // Remove a node from the front of the queue
                TreeNode node = queue.poll();
                // Add the value of the node to the sum
                sum += node.val;
                // If the node has a left child, add it to the queue
                if (node.left != null) queue.offer(node.left);
                // If the node has a right child, add it to the queue
                if (node.right != null) queue.offer(node.right);
            }
            // Add the average of the values of the nodes at the current level to the result list
            result.add(sum / size);
        }
        // Return the result list
        return result;
    }

}
