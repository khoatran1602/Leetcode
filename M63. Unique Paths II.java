class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Number of rows in the grid
        int rows = obstacleGrid.length;
        // Number of columns in the grid
        int cols = obstacleGrid[0].length;
        // 2D array to store the number of unique paths
        int[][] dp = new int[rows][cols];
        // If the starting point is an obstacle, return 0 as no unique path is possible
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        // Loop through each row
        for (int i = 0; i < rows; i++) {
            // Loop through each column
            for (int j = 0; j < cols; j++) {
                // If the current cell is an obstacle, skip it
                if (obstacleGrid[i][j] == 1) continue;
                // If the current cell is not the first row, add the number of unique paths from the previous row to the current cell
                if (i > 0) dp[i][j] += dp[i-1][j];
                // If the current cell is not the first column, add the number of unique paths from the previous column to the current cell
                if (j > 0) dp[i][j] += dp[i][j-1];
            }
        }
        // Return the number of unique paths from the starting point to the ending point
        return dp[rows-1][cols-1];
    }
}
