class Solution {
    public int longestConsecutive(int[] nums) {
        // If the input array is empty or has only one element, return its length
        if (nums.length == 0 || nums.length == 1) return nums.length;
        // Remove duplicates from the input array and sort it
        int[] distinctNums = Arrays.stream(nums).distinct().toArray();
        Arrays.sort(distinctNums);
        // Initialize variables for longest consecutive sequence and current sequence length
        int longestSequenceLength = 0;
        int currentSequenceLength = 0;
        // Print the distinct and sorted array (for debugging purposes)
        System.out.println(Arrays.toString(distinctNums));
        // Iterate through the sorted array, counting the length of each consecutive sequence
        for (int i = 0; i < distinctNums.length - 1; i++) {
            if (distinctNums[i] + 1 == distinctNums[i + 1]) {
                currentSequenceLength++;
            } else {
                longestSequenceLength = Math.max(longestSequenceLength, currentSequenceLength);
                currentSequenceLength = 0;
            }
        }
        // Check the length of the last sequence and update the longest sequence length accordingly
        longestSequenceLength = Math.max(longestSequenceLength, currentSequenceLength);
        // Add 1 to the longest sequence length and return it
        return longestSequenceLength + 1;
    }
}
