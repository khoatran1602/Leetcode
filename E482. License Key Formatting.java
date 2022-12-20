class Solution {
    public String licenseKeyFormatting(String s, int k) {
        s = s.toUpperCase();
        s = s.replaceAll("-", "");
        int count = 0;
        StringBuilder res = new StringBuilder();
        for (int i = s.length()-1; i >= 0; i--) {
            if (count != k) {
                res.append(s.charAt(i));
            } else {
                res.append("-");
                res.append(s.charAt(i));
                count = 0;
            }
            count++;
        }
        return res.reverse().toString();
    }
}
