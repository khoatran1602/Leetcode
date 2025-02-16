/**
 * LeetCode 944 - Delete Columns to Make Sorted
 * Time Complexity: O(N * M) where N is length of strings and M is number of strings
 * Space Complexity: O(1) as we only use constant extra space
 */
class Solution {
    /**
     * Counts the number of columns that need to be deleted to make strings lexicographically sorted
     * A column needs to be deleted if any character in that column is greater than the next character
     * 
     * @param strs Array of equal-length strings
     * @return Number of columns that need to be deleted
     */
    public int minDeletionSize(String[] strs) {
        // Guard against empty input
        if (strs == null || strs.length == 0) {
            return 0;
        }
        
        int deletionCount = 0;
        int stringLength = strs[0].length();
        int arrayLength = strs.length;
        
        // Check each column
        for (int col = 0; col < stringLength; col++) {
            // Compare characters in current column
            for (int row = 0; row < arrayLength - 1; row++) {
                // If current char is greater than next char, column needs deletion
                if (strs[row].charAt(col) > strs[row + 1].charAt(col)) {
                    deletionCount++;
                    break; // Move to next column once we find a violation
                }
            }
        }
        
        return deletionCount;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        // Example: Column 1 ('b' > 'a') needs deletion
        String[] example1 = {"cba", "daf", "ghi"};
        System.out.println("Number of columns to delete: " + sol.minDeletionSize(example1));
        
        // Additional test cases
        String[] example2 = {"a", "b", "c"};
        System.out.println("Number of columns to delete: " + sol.minDeletionSize(example2)); // Should output 0
    }
}