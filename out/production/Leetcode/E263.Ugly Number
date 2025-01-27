class Solution {
    public boolean isUgly(int n) {
        if (n == 1) return true;
        if (n == 0) return false;
        int temp = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                temp = n / 2;
            } else if (n % 3 == 0) {
                temp = n / 3;
            } else if (n % 5 == 0) {
                temp = n / 5;
            } else {
                break;
            }
            n = temp;
        }
        if (n == 1) {
            return true;
        }
        return false;
    }
}
