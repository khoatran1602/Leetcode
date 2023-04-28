class Solution {
    // Method to partition a string into palindromic substrings
    public List<List<String>> partition(String s) {
        // Create a list to store the resulting partitions
        List<List<String>> result = new ArrayList<>();
        
        // Create a list to store the current partition
        List<String> currentPartition = new ArrayList<>();
        
        // Recursively generate all possible partitions
        dfs(s, 0, currentPartition, result);
        
        // Return the resulting list of partitions
        return result;
    }

    // Recursive helper method to generate all possible partitions
    public void dfs(String s, int index, List<String> currentPartition, List<List<String>> result) {
        // If the index is equal to the length of the string, the current partition is a valid solution
        if (index == s.length()) {
            result.add(new ArrayList<>(currentPartition));
            return;
        }

        // Generate all possible substrings starting from the current index
        for (int i = index; i < s.length(); i++) {
            String str = s.substring(index, i + 1);
            if (isPalindrome(str)) { // If the substring is a palindrome, add it to the current partition and continue generating partitions recursively
                currentPartition.add(str);
                dfs(s, i + 1, currentPartition, result);
                currentPartition.remove(currentPartition.size() - 1); // Remove the last element from the current partition to backtrack and generate more solutions
            }
        }
    }

    // Method to check if a string is a palindrome
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false; // If the characters at the left and right indices are not equal, the string is not a palindrome
            left++;
            right--;
        }
        return true; // If the loop completes without returning false, the string is a palindrome
    }
}
