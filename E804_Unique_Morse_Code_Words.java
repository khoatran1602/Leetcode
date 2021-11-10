class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        if (words.length == 1) return 1;
        String[] list = new String[words.length];
        String[] morseCode =                             {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < words[i].length(); j++) {
                sb.append(morseCode[(int)(words[i].charAt(j) - 'a')]);
            }
            list[i] = sb.toString();
            sb.delete(0, sb.length());
        }
        Set<String> set = new HashSet(Arrays.asList(list));
        return set.size();
    }
}
