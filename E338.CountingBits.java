class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        int start = 0;
        while (start <= n) {
            int count = toBianry(start);
            res[start] = count;
            start++;
        }
        return res;
    }
    
    public static int toBianry(int n) {
        int res = 0;
        while (n > 0) {
            int temp = n % 2;
            if (temp == 1) {
                res++;
            }
            n = n / 2;
        }
        return res;
    }
}
