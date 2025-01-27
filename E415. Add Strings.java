class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        int res = 0;
        while (len1 > -1 || len2 > -1 || res != 0) {
            int temp = 0;
            if (len1 > -1) temp = num1.charAt(len1--) - '0';
            if (len2 > -1) temp = temp + num2.charAt(len2--) - '0';
            temp = temp + res;
            sb.append(temp%10);
            res = temp / 10;
        }
        return sb.reverse().toString();
    }
}
