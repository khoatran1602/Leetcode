class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        // Edge case: if the matrix is empty, return an empty list
        if (matrix.length == 0) return res;
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int startR = 0;
        int startCol = 0;
        int i = 0;

        // While we haven't traversed the entire matrix
        while (startR < rowLen && startCol < colLen) {
            // Traverse the top row from left to right
            for (i = startCol; i < colLen; i++) {
                res.add(matrix[startR][i]);
            }
            startR++;
            // Traverse the rightmost column from top to bottom
            for (i = startR; i < rowLen; i++) {
                res.add(matrix[i][colLen - 1]);
            }
            colLen--;
            // Traverse the bottom row from right to left
            if (startR < rowLen) {
                for (i = colLen - 1; i >= startCol; i--) {
                    res.add(matrix[rowLen - 1][i]);
                }
                rowLen--;
            }
            // Traverse the leftmost column from bottom to top
            if (startCol < colLen) {
                for (i = rowLen - 1; i >= startR; i--) {
                    res.add(matrix[i][startCol]);
                }
                startCol++;
            }
        }
        return res;
    }
}
