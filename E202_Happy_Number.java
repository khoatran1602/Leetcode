class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet();
        while (set.add(n)) {
            n = check(n);
            if (n == 1) {
                return true;
            }
        }
        return false;
    }
    public int check(int num) {
        int mod = 0;
        int number = 0;
        while (num > 0) {
            mod = num % 10;
            number = number + mod * mod;
            num = num / 10;
        }
        return number;
    }
}
