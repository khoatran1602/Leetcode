class Solution {
    public int addDigits(int num) {
        if (num < 10) return num;
        int first = 0;
        int second = 0;
        int temp = 0;
        while (num >= 10) {
            first = num / 10;
            second = num % 10;
            temp = first + second;
            if (temp < 10) return temp;
            num = temp;
        }
        return temp;
    }
}
