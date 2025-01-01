import java.util.Arrays;
import java.util.List;

/**
 * Solution class for the Replace Words problem
 * This class replaces longer words with their root words if found in the dictionary
 */
class Solution {
    /**
     * Replaces words in a sentence with their root words from the dictionary
     * @param dictionary List of root words
     * @param sentence Input sentence to process
     * @return Modified sentence with words replaced by their roots
     */
    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder modifiedSentence = new StringBuilder();
        
        // Split the sentence into individual words
        for (String currentWord : sentence.split(" ")) {
            String replacementWord = currentWord; // Default to original word
            
            // Check each root word in dictionary
            for (String rootWord : dictionary) {
                if (currentWord.startsWith(rootWord)) {
                    // Only replace if the root is shorter than the current word
                    if (currentWord.length() > rootWord.length()) {
                        replacementWord = rootWord;
                    }
                    break;
                }
            }
            modifiedSentence.append(replacementWord).append(" ");
        }
        
        // Remove trailing space and return result
        modifiedSentence.deleteCharAt(modifiedSentence.length() - 1);
        return modifiedSentence.toString();
    }
    
    /**
     * Main method for testing the solution
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1: Dictionary with single root word
        List<String> singleRootDictionary = Arrays.asList("cat");
        String testSentence1 = "the cattle was rattled by the battery";
        System.out.println("Test Case 1 Result: " + 
            solution.replaceWords(singleRootDictionary, testSentence1));
        
        // Test case 2: Dictionary with multiple root words
        List<String> multiRootDictionary = Arrays.asList("cat", "bat", "rat");
        String testSentence2 = "the cattle was rattled by the battery";
        System.out.println("Test Case 2 Result: " + 
            solution.replaceWords(multiRootDictionary, testSentence2));
    }
}