/**
 * LeetCode 657 - Robot Return to Origin
 * Problem: Determine if a robot returns to its original position after a sequence of moves
 * Time Complexity: O(n) where n is the length of moves string
 * Space Complexity: O(1)
 */
class Solution {
    /**
     * Determines if the robot returns to its starting position after executing all moves
     * @param moves A string containing the moves: 'U' (up), 'D' (down), 'L' (left), 'R' (right)
     * @return true if robot returns to origin, false otherwise
     */
    public boolean judgeCircle(String moves) {
        // Track coordinates: (0,0) is the starting position
        int horizontalPosition = 0;  // x-coordinate
        int verticalPosition = 0;    // y-coordinate

        // Process each move in the sequence
        for (int i = 0; i < moves.length(); i++) {
            char direction = moves.charAt(i);
            
            // Update position based on movement direction
            switch (direction) {
                case 'U':    // Move Up
                    verticalPosition++;
                    break;
                case 'D':    // Move Down
                    verticalPosition--;
                    break;
                case 'L':    // Move Left
                    horizontalPosition--;
                    break;
                case 'R':    // Move Right
                    horizontalPosition++;
                    break;
            }
        }

        // Robot returns to origin only if both coordinates are 0
        return horizontalPosition == 0 && verticalPosition == 0;
    }
    
    /**
     * Main method for testing the solution
     */
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Test cases
        System.out.println("Test case 1 (UD): " + sol.judgeCircle("UD"));  // Should print true
        System.out.println("Test case 2 (LL): " + sol.judgeCircle("LL"));  // Should print false
    }
}