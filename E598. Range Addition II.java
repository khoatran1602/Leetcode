class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        // Initialize two integer variables "row" and "col" with values of "m" and "n", respectively
        int row = m;
        int col = n;
        // Iterate through the 2D integer array "ops" using a for-each loop
        for (int[] op : ops) {
        // If the first element in the current array is less than "row", set "row" to the value of the first element
            if (op[0] < row) row = op[0];
        // If the second element in the current array is less than "col", set "col" to the value of the second element
            if (op[1] < col) col = op[1];
        }
        return row * col;
    }
}
