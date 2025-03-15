/**
 * Problem Description:
 * There is an array A of N integers sorted in non-decreasing order. In one move, you can either
 * remove an integer from A or insert an integer before or after any element of A. The goal is to
 * achieve an array in which all values X that are present in the array occur exactly X times.
 *
 * Example:
 * Given A=[1,1,3,4,4,4]:
 * • Value 1 occurs twice, value 3 occurs once, and value 4 occurs three times.
 * • You can remove one occurrence each of both 1 and 3, and insert one occurrence of 4,
 *   resulting in the array [1,4,4,4,4].
 * • In this array, every element X occurs exactly X times.
 *
 * Constraints:
 * • N is an integer within the range [1,100,000]
 * • Each element of array A is an integer within the range [1,100,000,000]
 * • Elements of array A are sorted in non-decreasing order
 *
 * Examples:
 * 1. A=[1,1,3,4,4,4] → return 3
 * 2. A=[1,2,2,2,5,5,5,8] → return 4
 * 3. A=[1,1,1,1,3,3,4,4,4,4,4] → return 5
 * 4. A=[10,10,10] → return 3
 */

/**
 * Solution for array frequency adjustment problem.
 * The goal is to modify an array so that each value X appears exactly X times,
 * using minimum number of moves (insertions or deletions).
 */
class Solution {
    /**
     * Calculates minimum moves needed to adjust array frequencies.
     * @param A Sorted array of integers
     * @return Minimum number of moves required
     */
    public int solution(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        return calculateMinimumMoves(A);
    }

    /**
     * Core logic to calculate minimum moves needed.
     * @param array Input array
     * @return Total minimum moves required
     */
    private int calculateMinimumMoves(int[] array) {
        int totalMoves = 0;
        int currentCount = 1;

        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i - 1]) {
                currentCount++;
            } else {
                totalMoves += calculateMovesForSequence(currentCount, array[i - 1]);
                currentCount = 1;
            }
        }

        // Handle the last sequence
        totalMoves += calculateMovesForSequence(currentCount, array[array.length - 1]);

        return totalMoves;
    }

    /**
     * Calculates moves needed for a sequence of same numbers.
     * @param count Number of occurrences
     * @param value The value being checked
     * @return Minimum moves needed for this sequence
     */
    private int calculateMovesForSequence(int count, int value) {
        int movesToAdjust = Math.abs(count - value);
        int movesToDelete = count;
        return Math.min(movesToAdjust, movesToDelete);
    }

    /**
     * Test cases for the solution.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test cases
        testCase(solution, new int[]{1, 1, 3, 4, 4, 4}, "Test Case 1");
        testCase(solution, new int[]{1, 2, 2, 2, 5, 5, 5, 8}, "Test Case 2");
        testCase(solution, new int[]{1, 1, 1, 1, 3, 3, 4, 4, 4, 4, 4}, "Test Case 3");
    }

    private static void testCase(Solution solution, int[] input, String testName) {
        System.out.println(testName + ": " + solution.solution(input));
    }
}