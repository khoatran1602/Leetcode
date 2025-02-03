/**
 * LeetCode 657 - Robot Return to Origin
 * Problem: Determine if robot returns to starting position after sequence of moves
 * Time Complexity: O(n) where n is length of moves string
 * Space Complexity: O(1)
 */
class Solution {
    /**
     * Determines if robot returns to origin after executing moves
     * @param moves String of moves: 'U'(up), 'D'(down), 'L'(left), 'R'(right)
     * @return true if robot returns to origin (0,0)
     */
    public boolean judgeCircle(String moves) {
        int x = 0;  // x-coordinate: positive = right, negative = left
        int y = 0;  // y-coordinate: positive = up, negative = down

        // Process each move and update position
        for (int i = 0; i < moves.length(); i++) {
            char direction = moves.charAt(i);
            switch (direction) {
                case 'U': y++;   break;  // Move up
                case 'D': y--;   break;  // Move down
                case 'L': x--;   break;  // Move left
                case 'R': x++;   break;  // Move right
            }
        }
        
        // Check if robot returned to origin (0,0)
        return x == 0 && y == 0;
    }

    /**
     * Main method for testing the solution
     */
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Test case 1 (\"UD\"): " + sol.judgeCircle("UD"));  // Expected: true
        System.out.println("Test case 2 (\"LL\"): " + sol.judgeCircle("LL"));  // Expected: false
    }
}