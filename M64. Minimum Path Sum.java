// class Solution {
//     public int minPathSum(int[][] grid) {
//         if (grid.length == 1 && grid[0].length == 1) return grid[0][0];
//         int[][] res = new int[grid.length][grid[0].length];
//         res[0][0] = grid[0][0];
//         for (int i = 1; i < grid[0].length; i++) {
//             res[0][i] = (res[0][i - 1] == 0 ? grid[0][i - 1] : res[0][i - 1]) + grid[0][i];
//         }
//         for (int i = 1; i < grid.length; i++) {
//             res[i][0] = (res[i - 1][0] == 0 ? grid[i - 1][0] : res[i - 1][0]) + grid[i][0];
//         }
//         for (int i = 1; i < grid.length; i++) {
//             for (int j = 1; j < grid[0].length; j++) {
//                 res[i][j] = Math.min(grid[i][j] + res[i-1][j], grid[i][j] + res[i][j-1]);
//             }
//         }
//         return res[grid.length - 1][grid[0].length - 1];
//     }
// }

class Solution {
    // Method to find the minimum path sum in a 2D grid
    public int minPathSum(int[][] grid) {
        // Get the number of rows and columns in the grid
        int rows = grid.length;
        int cols = grid[0].length;
        // Initialize 2D dynamic programming array
        int[][] dp = new int[rows][cols];
        // Set the initial value of the first cell in the dp array
        dp[0][0] = grid[0][0];
        // Calculate the minimum path sum for the first row
        for (int i = 1; i < cols; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        // Calculate the minimum path sum for the first column
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        // Calculate the minimum path sum for the rest of the cells
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        // Return the minimum path sum
        return dp[rows - 1][cols - 1];
    }
}
