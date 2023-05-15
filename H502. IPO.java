class Solution {
    public int findMaximizedCapital(int numProjects, int initialCapital, int[] profits, int[] capital) {
        // Create a 2D array to store project information (capital and profit)
        int[][] projects = new int[profits.length][2];
        
        // Create a max heap to store profits in descending order
        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        int projectCount = profits.length;
        
        // Initialize the project array with capital and profit values
        for (int i = 0; i < projectCount; i++) {
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }
        
        // Sort the projects array based on capital in ascending order
        Arrays.sort(projects, Comparator.comparingInt(a -> a[0]));
        
        int projectLen = projects.length;
        int j = 0;
        
        // Iterate through the projects to find the maximum profits
        for (int i = 0; i < numProjects; i++) {
            // Check if the current project's capital is less than or equal to the available capital
            while (j < projectLen && projects[j][0] <= initialCapital) {
                // Add the project's profit to the maxProfitHeap
                maxProfitHeap.offer(projects[j][1]);
                j++;
            }
            
            // If no profitable projects are available, exit the loop
            if (maxProfitHeap.isEmpty()) {
                break;
            }
            
            // Add the maximum profit from the heap to the available capital
            initialCapital += maxProfitHeap.poll();
        }
        
        return initialCapital;
    }
}
