class Solution {
    public int lengthOfLongestSubstring(String s) {
        int j = 0;
        int max = 0;        
        Set<Character> set = new HashSet<>();        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (set.contains(c)) {
                set.remove(s.charAt(j++));
            }
            set.add(c);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}
