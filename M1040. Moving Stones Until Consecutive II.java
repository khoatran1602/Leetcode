class Solution {
    // Method to determine the minimum and maximum number of moves required to move the stones to consecutive positions
    public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones); // Sort the stones in ascending order
        int i = 0, n = stones.length, minMoves = n; // Initialize variables for indices, length, and minimum moves required
        int maxMoves = Math.max(stones[n - 1] - n + 2 - stones[1], stones[n - 2] - stones[0] - n + 2); // Determine the maximum moves required
        for (int j = 0; j < n; j++) {
            while (stones[j] - stones[i] >= n) i++; // Determine the number of stones that can be moved to make consecutive positions
            if (j - i + 1 == n - 1 && stones[j] - stones[i] == n - 2)
                minMoves = Math.min(minMoves, 2); // If there is only one gap and it can be filled by moving two stones, update the minimum moves required
            else
                minMoves = Math.min(minMoves, n - (j - i + 1)); // Otherwise, update the minimum moves required based on the number of gaps
        }
        return new int[] {minMoves, maxMoves}; // Return the minimum and maximum moves required as an array
    }
}
