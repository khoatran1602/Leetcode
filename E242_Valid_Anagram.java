class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (Character c : s.toCharArray()) {
            if (!map1.containsKey(c)) {
                map1.put(c, 1);
            } else {
                map1.put(c, map1.get(c) + 1);
            }
        }
        for (Character c : t.toCharArray()) {
            if (!map2.containsKey(c)) {
                map2.put(c, 1);
            } else {
                map2.put(c, map2.get(c) + 1);
            }
        }
        for (var entry : map1.entrySet()) {
            if (map2.containsKey(entry.getKey())) {
                int check = map2.get(entry.getKey()) - entry.getValue();
                if (check != 0) return false;
            } else {
                return false;
            }
        }
        return true;
    }
}
