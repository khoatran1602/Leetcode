/**
 * LeetCode 649: Dota 2 Senate
 * In the Dota2 senate, there are two parties: Radiant and Dire.
 * Each senator can eliminate the voting rights of one senator from the other party.
 * The elimination process happens in a round-robin fashion.
 * The goal is to predict which party will win the final vote.
 */

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    /**
     * Predicts which party will win the final vote in the Dota2 senate.
     * 
     * @param senate A string representing the senate composition ('R' for Radiant, 'D' for Dire)
     * @return String indicating the winning party ("Radiant" or "Dire")
     * 
     * Time Complexity: O(n), where n is the length of the senate string
     * Space Complexity: O(n) to store the queues
     */
    public String predictPartyVictory(String senate) {
        // Initialize queues to store the indices of Radiant and Dire senators
        Queue<Integer> radiantQueue = new LinkedList<>();
        Queue<Integer> direQueue = new LinkedList<>();
        
        // Populate the queues with the indices of Radiant and Dire senators
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                radiantQueue.add(i);
            } else {
                direQueue.add(i);
            }
        }
        
        // Process the queues until one of them is empty
        while (!radiantQueue.isEmpty() && !direQueue.isEmpty()) {
            int radiantIndex = radiantQueue.poll();
            int direIndex = direQueue.poll();
            if (radiantIndex < direIndex) {
                // Radiant senator bans a Dire senator and rejoins the queue
                radiantQueue.add(radiantIndex + senate.length());
            } else {
                // Dire senator bans a Radiant senator and rejoins the queue
                direQueue.add(direIndex + senate.length());
            }
        }
        
        // Determine the winning party based on remaining senators
        return radiantQueue.isEmpty() ? "Dire" : "Radiant";
    }

    /**
     * Main method for testing the solution with various test cases
     * Test cases include:
     * 1. Equal number of senators from both parties
     * 2. More Radiant senators
     * 3. More Dire senators with different arrangements
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Senate with equal number of Radiant and Dire members
        String testSenate1 = "RD";
        System.out.println("Test Case 1 Result: " + solution.predictPartyVictory(testSenate1));

        // Test case 2: Senate with more Radiant members
        String testSenate2 = "RDD";
        System.out.println("Test Case 2 Result: " + solution.predictPartyVictory(testSenate2));

        // Test case 3: Senate with more Dire members
        String testSenate3 = "DDRRR";
        System.out.println("Test Case 3 Result: " + solution.predictPartyVictory(testSenate3));
    }
}