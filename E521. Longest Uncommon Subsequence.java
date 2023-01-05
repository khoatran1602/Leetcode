class Solution {
    public int findLUSlength(String a, String b) {
        if (a.length() == b.length() && a.equals(b)) return -1;
        int len = Math.max(a.length(), b.length());
        int res = 0;
        int temp = 0;
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j) && j >= temp) {
                    res++;
                    temp = j;
                    break;
                }
            }
        }
        if (res == 1) {
            return len;
        }
        return res == a.length() ? -1 : len;
    }
}
