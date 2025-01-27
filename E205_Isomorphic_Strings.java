class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap();
        
        for (int i = 0; i < s.length(); i++) {
            Character a = s.charAt(i);
            Character b = t.charAt(i);
            
            if (!map.containsKey(a)) {
                if (map.containsValue(b)) {
                    return false;
                } else {
                    map.put(a, b);
                }
            } else {
                if (b != map.get(a)) {
                    return false;
                }
            }
        }
        return true;
    }
}
