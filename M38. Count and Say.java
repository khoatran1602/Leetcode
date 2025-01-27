class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String str = countAndSay(n - 1);
        StringBuilder res = new StringBuilder();
        int count = 1;
        int i;
        for (i = 1; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(i - 1)) {
                res.append((char) (count + 48)).append(str.charAt(i - 1));
                count = 1;
            } else {
                count++;
            }
        }
        res.append((char) (count + 48)).append(str.charAt(i - 1));
        return res.toString();
    }
}
