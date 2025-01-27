class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> rowSet = new HashSet<>();
        HashSet<Character> colSet = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') continue;
                else {
                    if (!rowSet.add(board[i][j])) return false;
                }
            }
            rowSet = new HashSet<>();
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == '.') continue;
                else {
                    if (!colSet.add(board[j][i])) return false;
                }
            }
            colSet = new HashSet<>();
        }

        for (int i = 0; i < 9; i = i + 3) {
            for (int j = 0; j < 9; j = j + 3) {
                if (!check3x3(board, i, j)) return false;
            }
        }

        return true;
    }

    public boolean check3x3(char[][] board, int row, int col) {
        HashSet<Character> set = new HashSet<>();
        for (int i = row; i < 3 + row; i++) {
            for (int j = col; j < 3 + col; j++) {
                if (board[i][j] == '.') continue;
                else {
                    if (!set.add(board[i][j])) return false;
                }
            }
        }
        return true;
    }
}
