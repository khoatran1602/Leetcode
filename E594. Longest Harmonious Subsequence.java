class Solution {
    // Method to find the longest harmonious subsequence
    public int findLHS(int[] nums) {
        // Create a map to store the frequency of each number
        Map<Integer, Integer> map = new HashMap<>();
        // Iterate through the array to populate the map
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // Initialize max length of the harmonious subsequence
        int max = 0;
        // Iterate through the keys in the map
        for (int key : map.keySet()) {
            // If the map contains key+1, update the max length
            if (map.containsKey(key + 1)) 
                max = Math.max(max, map.get(key) + map.get(key + 1));
        }
        // Return the max length
        return max;
    }
}
