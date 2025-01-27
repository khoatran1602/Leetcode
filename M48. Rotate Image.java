class Solution {
    public void rotate(int[][] matrix) {
         //gets the number of rows
        int m = matrix.length;
        //gets the number of columns
        int n = matrix[0].length;
        //transpose the matrix
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < i; j++) {
                //swap the elements using a temporary variable
                swap(matrix, i, j, j, i);
            }
        }
        //flip the matrix along the vertical axis
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n / 2; j++) {
                //swap the elements using a temporary variable
                swap(matrix, i, j, i, n - j - 1);
            }
        }
    }

    public void swap(int[][] matrix, int row1, int col1, int row2, int col2) {
        //store the value of the first element in a temporary variable
        int temp = matrix[row1][col1];
        //assign the value of the second element to the first element
        matrix[row1][col1] = matrix[row2][col2];
        //assign the value of the temporary variable (original value of the first element) to the second element
        matrix[row2][col2] = temp;
    }
}
