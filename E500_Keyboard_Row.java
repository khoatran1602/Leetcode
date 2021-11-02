class Solution {
    public String[] findWords(String[] words) {
                Set<Character> set1 = new HashSet<>(Arrays.asList('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'));
        Set<Character> set2 = new HashSet<>(Arrays.asList('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'));
        Set<Character> set3 = new HashSet<>(Arrays.asList('z', 'x', 'c', 'v', 'b', 'n', 'm'));
        List<String> check = new ArrayList<>();
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int len = 0;
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (set1.contains(word.toLowerCase().charAt(i))) {
                    count1++;
                } else if (set2.contains(word.toLowerCase().charAt(i))) {
                    count2++;
                } else if (set3.contains(word.toLowerCase().charAt(i))) {
                    count3++;
                }
            }
            if (count1 == word.length() || count2 == word.length() || count3 == word.length()) {
                check.add(word);
                len++;
            }
            count1 = 0;
            count2 = 0;
            count3 = 0;
        }
        String[] list = new String[len];
        for (int i = 0; i < list.length; i++) {
            list[i] = check.get(i);
        }
        return list;
    }
}
