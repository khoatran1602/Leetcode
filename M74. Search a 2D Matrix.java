// class Solution {
//     // Method to search for a target value in a matrix
//     public boolean searchMatrix(int[][] matrix, int target) {
//         // Initialize the row index to 0
//         int row = 0;
//         // Iterate through the rows of the matrix
//         for (int i = 0; i < matrix.length; i++) {
//             // Check if the target is equal to the first or last element in the current row
//             if (matrix[i][0] == target || matrix[i][matrix[0].length - 1] == target) return true;
//             // If the target is less than the first element in the current row, return false
//             if (matrix[i][0] > target) return false;
//             // If the target is less than the last element in the current row, set the row index to the current row and break out of the loop
//             if (matrix[i][matrix[0].length - 1] > target) {
//                 row = i;
//                 break;
//             }
//         }
//         // Iterate through the elements in the target row
//         for (int i = 0; i < matrix[0].length; i++) {
//             // If the target is found, return true
//             if (matrix[row][i] == target) return true;
//         }
//         // If the target is not found, return false
//         return false;
//     }
// }

class Solution {
    // Method to search for a target value in a matrix
    public boolean searchMatrix(int[][] matrix, int target) {
        // Get the number of rows and columns in the matrix
        int m = matrix.length;
        int n = matrix[0].length;
        // Check if the matrix is empty
        if (m == 0 || n == 0) {
            return false;
        }
        // Initialize the left and right indices for binary search
        int left = 0, right = m * n - 1;
        // Perform binary search on the matrix
        while (left <= right) {
            // Calculate the middle index and the corresponding value
            int mid = (left + right) / 2;
            int midValue = matrix[mid / n][mid % n];
            // Check if the middle value is equal to the target
            if (midValue == target) {
                return true;
            // If the middle value is less than the target, search the right half of the array
            } else if (midValue < target) {
                left = mid + 1;
            // If the middle value is greater than the target, search the left half of the array
            } else {
                right = mid - 1;
            }
        }
        // If the target is not found, return false
        return false;
    }
}

