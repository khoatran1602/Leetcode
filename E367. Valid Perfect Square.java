class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        long high = num;
        long low = 1;
        while (high >= low) {
            long mid = low + (high - low) / 2;
            if (mid * mid == num) return true;
            if (mid * mid < num) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
}
