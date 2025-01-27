class Solution {
    // Entry point method to group anagrams of words in an array
    public List<List<String>> groupAnagrams(String[] strs) {
        // Initialize a list to store the final result
        List<List<String>> res = new ArrayList<>();
        // Initialize a HashMap to store the anagrams
        HashMap<String, List<String>> map = new HashMap<>();
        // Iterate through the input array of strings
        for (String str : strs) {
            // Convert the string to character array and sort it
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            // Convert the sorted character array back to a string
            String s = new String(chars);
            // Check if the map already contains the sorted string
            if (!map.containsKey(s)) {
                // If not, add an empty list with the sorted string as the key
                map.put(s, new ArrayList<>());
            }
            // Add the original string to the list of the corresponding sorted string
            map.get(s).add(str);
        }
        // Iterate through the keys in the map
        for (String key : map.keySet()) {
            // Add the list of anagrams for each key to the final result
            res.add(map.get(key));
        }
        // Return the final result
        return res;
    }
}
