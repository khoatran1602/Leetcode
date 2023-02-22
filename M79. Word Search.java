class Solution {
    // Method to check if a word exists on a board of characters
    public boolean exist(char[][] board, String word) {
        // Get the dimensions of the board
        int m = board.length;
        int n = board[0].length;
        // Create a 2D array to keep track of visited cells
        boolean[][] visited = new boolean[m][n];
        // Iterate over every cell in the board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If the current cell contains the first letter of the word, search for the rest of the word
                if (board[i][j] == word.charAt(0)) {
                    if (search(board, visited, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        // If the word is not found, return false
        return false;
    }
    
    // Recursive helper method to search for the rest of the word
    private boolean search(char[][] board, boolean[][] visited, String word, int i, int j, int k) {
        // Base case: if all letters in the word have been found, return true
        if (k == word.length()) {
            return true;
        }
        // Get the dimensions of the board
        int m = board.length;
        int n = board[0].length;
        // If the current cell is out of bounds, has already been visited, or does not contain the next letter in the word, return false
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || board[i][j] != word.charAt(k)) {
            return false;
        }
        // Mark the current cell as visited
        visited[i][j] = true;
        // Recursively search for the next letter in the word in all four adjacent cells
        boolean res = search(board, visited, word, i + 1, j, k + 1)
                || search(board, visited, word, i - 1, j, k + 1)
                || search(board, visited, word, i, j + 1, k + 1)
                || search(board, visited, word, i, j - 1, k + 1);
        // Mark the current cell as unvisited
        visited[i][j] = false;
        // Return whether the word was found or not
        return res;
    }
}
