class Solution {
    // Method to generate all possible combinations of k numbers from 1 to n
    public List<List<Integer>> combine(int n, int k) {
        // Create a new List to hold all possible combinations
        List<List<Integer>> result = new ArrayList<>();
        // Call the helper method to generate combinations
        combineHelper(1, n, new ArrayList<>(), result, k);
        // Return the List of combinations
        return result;
    }

    // Recursive helper method to generate combinations
    public void combineHelper(int start, int end, List<Integer> current, List<List<Integer>> result, int k) {
        // Base case: if the current List contains k numbers, add it to the result List and return
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }
        // Generate all possible combinations starting from the current number
        for (int i = start; i <= end; i++) {
            current.add(i);
            // Recursively call the helper method to generate combinations with the next number
            combineHelper(i + 1, end, current, result, k);
            // Backtrack by removing the last number to try other combinations
            current.remove(current.size() - 1);
        }
    }
}
