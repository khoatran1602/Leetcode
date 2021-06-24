class Solution {
    public int myAtoi(String s) {
      String s = "  -12  23 6 3505 2222222 ";
        if (s.length() == 0 || s == null) {
            return 0;
        }
        s = s.trim();
        char firstChar = s.charAt(0);
        int sign = 1;
        int count = 0;
        long sum = 0;
        if (firstChar == "+") {
            sign  = 1;
            count++;
        } else if (firstChar == "-") {
            sign = -1;
            count++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) return (int) sum * sign;
                sum = sum * 10 + s.charAt(i) - '0';
            if (sign == 1 && sum > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (sign == -1 && sum < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return (int) sum * sign;
    }
}
