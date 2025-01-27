class Solution {
    public String convertToBase7(int num) {
        if (num == 0) return "0";
       StringBuilder s = new StringBuilder();
        int temp = num;
        if (num < 0) {
            num = num * (-1);
        }
        while (num >= 1) {
            char digit = (char) (num % 7 + '0');
            s.append(digit);
            num = num / 7;
        }
        if (temp < 0) {
            s.append("-");
        }
        s.reverse();
        return s.toString();
    }
}
