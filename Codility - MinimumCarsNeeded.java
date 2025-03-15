/**
 * Problem Description:
 * A group of friends is going on holiday together. They arrive at the meeting point using N cars.
 * For each car K (in range [0..N-1]):
 * - P[K] represents the number of people in the car
 * - S[K] represents the number of seats in the car
 * 
 * Goal: To be ecological, they want to use minimum number of cars possible by redistributing people.
 * 
 * Task: Write a function that returns the minimum number of cars needed.
 * 
 * Example:
 * P = [1, 2, 3, 4] (people in each car)
 * S = [2, 3, 4, 5] (seats in each car)
 * Result: 2 cars needed
 */

import java.util.Arrays;

class Solution {
    /**
     * Calculates the minimum number of cars needed to transport all people.
     * @param P Array containing number of people in each car
     * @param S Array containing number of seats in each car
     * @return Minimum number of cars needed
     * @throws IllegalArgumentException if input arrays are invalid
     */
    public int solution(int[] P, int[] S) {
        // Input validation
        if (P == null || S == null || P.length == 0 || S.length == 0) {
            throw new IllegalArgumentException("Invalid input arrays");
        }

        return calculateMinimumCars(P, S);
    }

    /**
     * Core logic to calculate minimum cars needed.
     */
    private int calculateMinimumCars(int[] P, int[] S) {
        int totalPeople = Arrays.stream(P).sum();
        
        // Sort seats in descending order
        int[] sortedSeats = Arrays.stream(S)
                                 .boxed()
                                 .sorted((a, b) -> b - a)
                                 .mapToInt(Integer::intValue)
                                 .toArray();
        
        return countRequiredCars(totalPeople, sortedSeats);
    }

    /**
     * Counts how many cars are needed based on total people and available seats.
     */
    private int countRequiredCars(int totalPeople, int[] sortedSeats) {
        int sumSeats = 0;
        int carsNeeded = 0;
        
        for (int seats : sortedSeats) {
            sumSeats += seats;
            carsNeeded++;
            if (sumSeats >= totalPeople) {
                break;
            }
        }
        
        return carsNeeded;
    }

    /**
     * Test cases
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test cases
        testCase(solution, 
                new int[]{1, 2, 3, 4}, 
                new int[]{2, 3, 4, 5},
                "Test Case 1");
        
        testCase(solution, 
                new int[]{1, 2, 3, 4}, 
                new int[]{2, 3, 4, 5, 6},
                "Test Case 2");
    }

    private static void testCase(Solution solution, int[] P, int[] S, String testName) {
        System.out.println(testName + ": " + solution.solution(P, S));
    }
}
