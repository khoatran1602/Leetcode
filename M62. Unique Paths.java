class Solution {
    // Method to calculate unique paths in a grid from the top left to the bottom right
    public int uniquePaths(int rows, int cols) {
        // Initialize a 2D array to store intermediate path count values
        int[][] dp = new int[rows][cols];
        
        // Initialize the first column with 1
        for (int i = 0; i < rows; i++) {
            dp[i][0] = 1;
        }
        
        // Initialize the first row with 1
        for (int j = 0; j < cols; j++) {
            dp[0][j] = 1;
        }
        
        // Fill in the remaining values using dynamic programming
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        
        // Return the path count for the bottom right
        return dp[rows-1][cols-1];
    }
}

/*  m = 3, n = 7
    1   1   1   1   1   1   1
    1   2   3   4   5   6   7
    1   3   6   10  15  21  28

*/
