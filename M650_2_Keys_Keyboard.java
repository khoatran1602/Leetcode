
/**
 * Solution for LeetCode 650: 2 Keys Keyboard
 * Problem: Find minimum number of operations to get n 'A' characters starting with one 'A'
 * Operations allowed: Copy All, Paste
 */
class Solution {
    /**
     * Calculates minimum steps needed to get n 'A' characters
     * @param targetLength the desired number of 'A' characters
     * @return minimum number of steps (copy + paste operations)
     */
    public int minSteps(int targetLength) {
        // Base cases
        if (targetLength == 1) return 0;  // Already have one 'A'
        if (targetLength < 6) return targetLength;  // Optimal solution for small numbers
        
        // If target is prime, we need exactly n steps
        if (isPrime(targetLength)) return targetLength;
        
        int totalSteps = 0;
        int remainingLength = targetLength;
        
        while (remainingLength != 1) {
            // If even number, divide by 2 (copy + paste = 2 steps)
            if (remainingLength % 2 == 0) {
                totalSteps += 2;
                remainingLength = remainingLength / 2;
            } else {
                // For odd numbers
                if (isPrime(remainingLength)) {
                    totalSteps += remainingLength;
                    break;
                }
                // Find largest factor below square root
                for (int factor = (int) Math.sqrt(remainingLength); factor >= 3; factor--) {
                    if (remainingLength % factor == 0) {
                        totalSteps += factor;
                        remainingLength = remainingLength / factor;
                        break;
                    }
                }
            }
        }
        return totalSteps;
    }

    /**
     * Checks if a number is prime
     * @param number number to check
     * @return true if number is prime, false otherwise
     */
    public boolean isPrime(int number) {
        for (int divisor = 2; divisor <= Math.sqrt(number); divisor++) {
            if (number % divisor == 0) return false;
        }
        return true;
    }
    
    /**
     * Main method for testing
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minSteps(3));
    }
}