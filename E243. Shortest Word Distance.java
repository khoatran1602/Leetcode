 public Solution {
        public static int shortestDistance (String[]words, String word1, String word2) {
            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                map.put(words[i], i);
            }
            int res = 0;
            int posOne = map.get(word1);
            int posTwo = map.get(word2);
            return posTwo - posOne < 0 ? posOne - posTwo : posTwo - posOne;
        }
 }
