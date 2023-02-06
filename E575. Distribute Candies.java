class Solution {
    // Method to distribute candies among siblings
    public int distributeCandies(int[] candyType) {
        // Count the number of unique candies
        int uniqueCandies = (int) Arrays.stream(candyType)
                .distinct() // Find distinct values
                .count(); // Count the number of distinct values
        // Return the minimum of the number of unique candies and half the length of the array
        return Math.min(uniqueCandies, candyType.length / 2);
    }
}
