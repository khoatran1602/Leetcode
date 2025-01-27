class Solution {
    public String reverseWords(String s) {
        // Initialize a StringBuilder to store the reversed words
        StringBuilder stringBuilder = new StringBuilder();
        // Initialize a temporary StringBuilder to reverse the current word
        StringBuilder temp = new StringBuilder();
        // Keep track of the index of the start of the current word
        int index = 0;
        // Iterate through the input string
        for (int i = 0; i < s.length(); i++) {
            // Check if current character is a space or if we have reached the end of the input string
            if (s.charAt(i) == ' ' || i == s.length() - 1) {
                // If we have reached the end of the input string, reverse the last word
                if (i == s.length() - 1) {
                    temp.append(s, index, i+1).reverse();
                } else {
                    // Otherwise, reverse the current word
                    temp.append(s, index, i).reverse();
                }
                // Add a space after the current word if we haven't reached the end of the input string
                if (i != s.length() - 1) {
                    temp.append(" ");
                }
                // Append the reversed word to the final output
                stringBuilder.append(temp);
                // Clear the temporary StringBuilder
                temp.delete(0, temp.length());
                // Update the index to start of next word
                index = i+1;
            }
        }
        // Return the final reversed string
        return stringBuilder.toString();
    }
}
