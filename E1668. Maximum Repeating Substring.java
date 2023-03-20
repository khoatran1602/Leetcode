class Solution {
    public int maxRepeating(String sequence, String word) {
        // If the word is not in the sequence, then it cannot be repeated, so return 0.
        if (!sequence.contains(word)) {
            return 0;
        }
        
        // Initialize a variable to keep track of the maximum number of repetitions.
        int res = 0;
        
        // Initialize a StringBuilder to gradually build the repeated word.
        StringBuilder sb = new StringBuilder();
        
        // Keep adding the word to the StringBuilder until its length is greater than or equal to the sequence length.
        while (sb.length() <= sequence.length()) {
            sb.append(word);
            
            // If the sequence contains the current state of the StringBuilder, then the word has been repeated again, so increment the count.
            if (sequence.contains(sb.toString())) {
                res++;
            } else {
                break;  // If the sequence does not contain the current state of the StringBuilder, then stop adding to it.
            }
        }
        
        // Return the maximum number of repetitions found.
        return res;
    }
}
