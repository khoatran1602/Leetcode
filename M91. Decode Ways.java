class Solution {
    // This method takes a string of digits as input and returns the number of ways to decode it
    public int numDecodings(String s) {
        
        // If the first character is '0', the input string cannot be decoded, so return 0
        if (s.charAt(0) == '0') return 0;
        
        // Get the length of the input string
        int length = s.length();
        
        // Create an array to store the number of ways to decode the string up to each character
        int[] numWays = new int[length + 1];
        
        // Initialize the first two values of the array, as the number of ways to decode a string of length 0 and 1
        numWays[0] = 1;
        numWays[1] = 1;
        
        // Loop through the remaining characters of the input string
        for (int i = 2; i <= length; i++) {
            
            // If the current character can be decoded by itself (i.e., is not '0'), add the number of ways to decode the string up to the previous character
            if (s.charAt(i - 1) != '0') {
                numWays[i] += numWays[i - 1];
            }
            
            // If the current and previous characters can be decoded together (i.e., their combined value is between 10 and 26), add the number of ways to decode the string up to two characters ago
            if (s.charAt(i - 2) != '0' && (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26) {
                numWays[i] += numWays[i - 2];
            }
        }
        
        // Return the number of ways to decode the entire input string
        return numWays[length];
    }

}
