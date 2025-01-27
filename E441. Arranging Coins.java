class Solution {
    public static int arrangeCoins(int n) {
        if (n == 1) return 1;
		int temp = 1;
		int sum = 0;
		while (sum >= 0) {
			int sub = n - temp;
			if (sub == 0) return sum + 1;
			else if (sub < 0) return sum;
			n = sub;
			sum++;
			temp++;
		}
		return sum;
	}
}
