import java.util.Arrays;

/**
 * LeetCode 661 - Image Smoother
 * Problem: Apply a smoothing operation to an image represented by a 2D integer array
 * Time Complexity: O(m*n) where m,n are image dimensions
 * Space Complexity: O(m*n) for result array
 */
class Solution {
    /**
     * Applies smoothing operation to an image by averaging each pixel with its neighbors
     * @param img 2D array representing grayscale image (0-255)
     * @return New 2D array with smoothing applied
     */
    public int[][] imageSmoother(int[][] img) {
        int rows = img.length;
        int cols = img[0].length;
        int[][] smoothedImage = new int[rows][cols];
        
        // Process each pixel in the image
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // Calculate average of surrounding pixels (3x3 window)
                int pixelSum = 0;
                int validPixels = 0;
                
                // Check all 8 neighboring pixels plus current pixel
                for (int neighborRow = row - 1; neighborRow <= row + 1; neighborRow++) {
                    for (int neighborCol = col - 1; neighborCol <= col + 1; neighborCol++) {
                        // Check if neighbor position is within image bounds
                        if (isValidPixel(neighborRow, neighborCol, rows, cols)) {
                            pixelSum += img[neighborRow][neighborCol];
                            validPixels++;
                        }
                    }
                }
                
                // Store average value in result array
                smoothedImage[row][col] = pixelSum / validPixels;
            }
        }
        
        return smoothedImage;
    }
    
    /**
     * Helper method to check if pixel coordinates are within image bounds
     */
    private boolean isValidPixel(int row, int col, int maxRows, int maxCols) {
        return row >= 0 && row < maxRows && col >= 0 && col < maxCols;
    }
    
    /**
     * Main method for testing the solution
     */
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Test case 1: Simple 3x3 binary image
        int[][] test1 = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };
        System.out.println("Test case 1 (Binary image): " + 
            Arrays.deepToString(sol.imageSmoother(test1)));
        
        // Test case 2: 3x3 grayscale image
        int[][] test2 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("Test case 2 (Grayscale image): " + 
            Arrays.deepToString(sol.imageSmoother(test2)));
    }
}