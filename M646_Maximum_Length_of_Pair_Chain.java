import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

/**
 * Solution class for finding the maximum length of a pair chain
 */
class Solution {
    /**
     * Finds the longest chain that can be formed from the given pairs
     * @param pairSequence 2D array containing pairs where each pair is [start, end]
     * @return The length of the longest valid chain
     */
    public int findLongestChain(int[][] pairs) {
        // Sort pairs based on the second element (right boundary) for greedy approach
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
        
        // Debug print to show sorted pairs
        System.out.println(Arrays.deepToString(pairs));
        
        // Array to store the right boundaries of selected pairs
        int[] chainEndings = new int[pairs.length];
        
        // Initialize with the first pair's right boundary
        int currentEnd = pairs[0][1];
        chainEndings[0] = pairs[0][1];
        int chainLength = 1;  // Counter for chain length

        // Iterate through remaining pairs
        for (int i = 1; i < pairs.length; i++) {
            // Debug prints
            System.out.println("Current End: " + currentEnd);
            System.out.println("Pairs[i][0]: " + pairs[i][0]);
            
            // If current pair's left boundary is greater than previous right boundary
            // it can be added to the chain
            if (pairs[i][0] > currentEnd) {
                chainEndings[chainLength++] = pairs[i][1];  // Store the right boundary
                currentEnd = pairs[i][1];    // Update current end
            }
        }

        // Debug prints
        System.out.println("Chain Length: " + chainLength);
        System.out.println(Arrays.toString(chainEndings));
        
        // Create set to store unique right boundaries
        HashSet<Integer> uniqueEndings = new HashSet<>();
        for (int i = 0; i < chainEndings.length; i++) {
            uniqueEndings.add(chainEndings[i]);
        }
        
        // Return size of set which represents chain length
        return uniqueEndings.size();
    }

    /**
     * Main method for testing the solution
     */
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] pairs = {{1,2}, {2,3}, {3,4}};  // Test case
        System.out.println(sol.findLongestChain(pairs));
    }
}