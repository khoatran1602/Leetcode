class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        //if the number of rows times the number of columns does not equal the length of the matrix times the length of the first row, return the matrix
        if (r * c != mat.length * mat[0].length) return mat;
        //create a new matrix with the given number of rows and columns
        int[][] newMat = new int[r][c];
        //set row and column to 0
        int row = 0;
        int col = 0;
        //loop through each element in the matrix
        for (int i = 0; i < mat.length; i++) {
            //if the column is greater than the number of columns minus 1, increment row and set column to 0
            for (int j = 0; j < mat[0].length; j++) {
                if (col > c - 1) {
                    row++;
                    col = 0;
                }
                //set the new matrix's row and column to the current element in the matrix
                newMat[row][col++] = mat[i][j];
            }
        }
        return newMat;
    }
}

// class Solution {
//     public int[][] matrixReshape(int[][] mat, int r, int c) {
//         if (r * c != mat.length * mat[0].length) return mat;
//         int[][] newMat = new int[r][c];
//         int row = 0;
//         int col = 0;
//         for (int i = 0; i < mat.length * mat[0].length; i++) {
//             if (col > c - 1) {
//                 row++;
//                 col = 0;
//             }
//             newMat[row][col++] = mat[i / mat[0].length][i % mat[0].length];
//         }
//         return newMat;
//     }
// }
