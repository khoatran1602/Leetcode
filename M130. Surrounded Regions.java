class Solution {
    public void solve(char[][] board) {
        // If the board is empty, return
        if (board.length == 0) {
            return;
        }
        // Get the number of columns and rows in the board
        int numCols = board[0].length;
        int numRows = board.length;
        // Iterate over the left and right columns, and the top and bottom rows,
        // marking each 'O' cell and its neighbors as 'A'.
        for (int i = 0; i < numRows; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][numCols - 1] == 'O') {
                dfs(board, i, numCols - 1);
            }
        }
        for (int i = 0; i < numCols; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }
            if (board[numRows - 1][i] == 'O') {
                dfs(board, numRows - 1, i);
            }
        }
        // Iterate over the entire board, changing 'O' cells to 'X' cells
        // and 'A' cells back to 'O' cells.
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    // A recursive method that marks a cell and its neighbors as 'A'
    // if the cell is an 'O' cell that is not surrounded by 'X' cells.
    public void dfs(char[][] board, int startRow, int startCol) {
        // If the cell is out of bounds or not an 'O' cell, return.
        if (startRow < 0 || startCol < 0 || startRow >= board.length || startCol >= board[0].length || board[startRow][startCol] != 'O') {
            return;
        }
        // Mark the cell as 'A'.
        board[startRow][startCol] = 'A';
        // Recursively mark the cell's neighbors as 'A'.
        dfs(board, startRow + 1, startCol);
        dfs(board, startRow - 1, startCol);
        dfs(board, startRow, startCol + 1);
        dfs(board, startRow, startCol - 1);
    }
}
