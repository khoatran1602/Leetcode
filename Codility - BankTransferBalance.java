/**
 * Problem Description:
 * Calculate the minimum initial balance needed for two bank accounts (A and B) such that
 * neither account goes negative during a series of transfers.
 *
 * Input:
 * - String recipients: Sequence of transfers ('A' means transfer to B, 'B' means transfer to A)
 * - int[] amounts: Amount for each transfer
 *
 * Examples:
 * 1. "BAABA", [2,4,1,1,2] → [2,4]
 *    Initial: A=2, B=4
 *    B→A(2): A=4, B=2
 *    A→B(4): A=0, B=6
 *    A→B(1): A=-1, B=7
 *    B→A(1): A=0, B=6
 *    A→B(2): A=-2, B=8
 *
 * 2. "ABAB", [10,5,10,15] → [0,15]
 * 3. "B", [100] → [100,0]
 * 4. "AB", [3,3] → [0,3]
 */

import java.util.Arrays;

class Solution {
    /**
     * Calculates minimum initial balance needed for both accounts.
     * @throws IllegalArgumentException if inputs are invalid
     */
    public int[] solution(String recipients, int[] amounts) {
        validateInput(recipients, amounts);
        return calculateMinimumBalance(recipients, amounts);
    }

    private void validateInput(String recipients, int[] amounts) {
        if (recipients == null || amounts == null || 
            recipients.length() != amounts.length || 
            recipients.length() == 0) {
            throw new IllegalArgumentException("Invalid input parameters");
        }
        if (!recipients.matches("[AB]+")) {
            throw new IllegalArgumentException("Recipients string should only contain 'A' or 'B'");
        }
    }

    private int[] calculateMinimumBalance(String recipients, int[] amounts) {
        int balA = 0, balB = 0;
        int minA = 0, minB = 0;

        for (int i = 0; i < recipients.length(); i++) {
            if (recipients.charAt(i) == 'A') {
                balA += amounts[i];
                balB -= amounts[i];
                minB = Math.min(minB, balB);
            } else {
                balB += amounts[i];
                balA -= amounts[i];
                minA = Math.min(minA, balA);
            }
        }

        return new int[] { -minA, -minB };
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test cases
        testCase(solution, "BAABA", new int[]{2, 4, 1, 1, 2}, "Test 1");
        testCase(solution, "ABAB", new int[]{10, 5, 10, 15}, "Test 2");
        testCase(solution, "B", new int[]{100}, "Test 3");
        testCase(solution, "AB", new int[]{3, 3}, "Test 4");
    }

    private static void testCase(Solution solution, String recipients, int[] amounts, String testName) {
        try {
            System.out.printf("%s: %s%n", testName, 
                Arrays.toString(solution.solution(recipients, amounts)));
        } catch (IllegalArgumentException e) {
            System.out.printf("%s: Error - %s%n", testName, e.getMessage());
        }
    }
}
