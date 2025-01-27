class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), s, 0);
        return ans;
    }
    
    private void backtrack(List<String> ans, List<String> parts, String s, int start) {
        // If we have 4 parts and used all the digits in s
        if (parts.size() == 4 && start == s.length()) {
            ans.add(String.join(".", parts));
            return;
        }
        
        // If we have 4 parts but didn't use all the digits in s
        if (parts.size() == 4) {
            return;
        }
        
        // Try all possible lengths for the next part
        for (int len = 1; len <= 3 && start + len <= s.length(); len++) {
            String str = s.substring(start, start + len);
            
            // Check for leading zeros
            if (str.startsWith("0") && str.length() > 1) {
                continue;
            }
            
            // Check for value range
            int val = Integer.parseInt(str);
            if (val < 0 || val > 255) {
                continue;
            }
            
            parts.add(str);
            backtrack(ans, parts, s, start + len);
            parts.remove(parts.size() - 1);
        }
    }
}
