class Solution {
    // Entry method to generate a n x n spiral matrix
    public int[][] generateMatrix(int n) {
        // Create an n x n matrix filled with zeros
        int[][] matrix = new int[n][n];

        // Initialize variables to track the four sides of the matrix
        int left = 0, right = n - 1;
        int top = 0, bottom = n - 1;

        // Variable to store the current number
        int number = 1;

        // Variable to track the current direction of the spiral
        int direction = 0;

        // Loop until the left boundary is greater than the right boundary or the top boundary is greater than the bottom boundary
        while (left <= right && top <= bottom) {
            // If the current direction is 0, move from left to right along the top boundary
            if (direction == 0) {
                for (int i = left; i <= right; i++) {
                    matrix[top][i] = number;
                    number++;
                }
                direction = 1;
                top++;
            }
            // If the current direction is 1, move from top to bottom along the right boundary
            else if (direction == 1) {
                for (int i = top; i <= bottom; i++) {
                    matrix[i][right] = number;
                    number++;
                }
                direction = 2;
                right--;
            }
            // If the current direction is 2, move from right to left along the bottom boundary
            else if (direction == 2) {
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = number;
                    number++;
                }
                direction = 3;
                bottom--;
            }
            // If the current direction is 3, move from bottom to top along the left boundary
            else if (direction == 3) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = number;
                    number++;
                }
                direction = 0;
                left++;
            }
        }
        // Return the generated matrix
        return matrix;
    }
}
