class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<String, Character> map = new HashMap<>();
        String[] sub = s.split(" ", s.length());
        if (sub.length != pattern.length()) return false;
        for (int i = 0; i < sub.length; i++) {
            if (map.containsKey(sub[i]) && !map.get(sub[i]).equals(pattern.charAt(i))
             || !map.containsKey(sub[i]) && map.containsValue(pattern.charAt(i))) {
                return false;
            } else {
                map.put(sub[i], pattern.charAt(i));
            }
        }
        return true;
    }
}
