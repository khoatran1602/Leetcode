class Solution {
    public String makeFancyString(String inputString) {
        int stringLength = inputString.length();
        int repeatedCharCount = 0;
        StringBuilder result = new StringBuilder();
        
        // Add first character to result
        result.append(inputString.charAt(0));
        
        // Loop through the string starting from the second character
        for (int i = 1; i < stringLength; i++) {
            // Check if current character is the same as the previous character
            if (inputString.charAt(i) == inputString.charAt(i - 1)) {
                // If the current character is the same as the previous character and
                // the previous character was already repeated once, skip adding the current character
                if (repeatedCharCount == 1) {
                    continue;
                }
                // If the previous character was not repeated yet, increment the repeated character count
                // and add the current character to the result
                repeatedCharCount++;
                result.append(inputString.charAt(i));
            } else {
                // If the current character is different from the previous character, reset the repeated character count
                // and add the current character to the result
                repeatedCharCount = 0;
                result.append(inputString.charAt(i));
            }
        }
        return result.toString();
    }
}
