class Solution {
    public String reverseVowels(String s) {
        int end = s.length() - 1;
        char[] newS = s.toCharArray();
        char[] check = {'u', 'e', 'o', 'a', 'i', 'A', 'E', 'O', 'U', 'I'};
        if (s.length() == 1) return s;
        if (s.length() == 2) {
            if (String.valueOf(check).contains(Character.toString(newS[0])) &&
                    String.valueOf(check).contains(Character.toString(newS[1]))) {
                char temp = newS[0];
                newS[0] = newS[1];
                newS[1] = temp;
            }
        } else {
            for (int i = 0;;) {
                if (i >= end) break;
                if (!String.valueOf(check).contains(Character.toString(newS[end]))) {
                    end--;
                }
                if (!String.valueOf(check).contains(Character.toString(newS[i]))) {
                    i++;
                }
                if (String.valueOf(check).contains(Character.toString(newS[i])) && String.valueOf(check).contains(Character.toString(newS[end]))) {
                    char temp = newS[i];
                    newS[i] = newS[end];
                    newS[end] = temp;
                    end--;
                    i++;
                }
            }
        }
        s = new String(newS);
        return s;
    }
    
}
