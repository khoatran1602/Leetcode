class Solution {
    public double myPow(double x, int n) {
        // if x is 1, return 1
        if (x == 1) return 1;
        // if x is -1, check n is odd or even. 
        if (x == -1 && n < 0) return 1;
        if (x == -1 && n % 2 != 0) return -1;
        else if (x == -1 && n % 2 == 0) return 1;
        // if n is greater than max int, return 0
        if (n > Integer.MAX_VALUE) return 0;
        // if n is min int, return 0
        if (n == Integer.MIN_VALUE) return 0;
        double res = 1;
        // if n is negative, change the sign of n, and return 1/res
        if (n < 0) {
            n = n * (-1);
            for (int i = 0; i < n; i++) {
                res = res * x;
            }
            return 1/res;
        }
        // if n is positive, return res
        for (int i = 0; i < n; i++) {
            res = res * x;
        }
        return res;
    }
}

class Solution {
    public double myPow(double x, long n) {
        // if n is 0 or x is 1, return 1
        if(n==0 || x==1)
            return 1;
        // if x is 0, return 0
        if(x == 0)
            return 0;

        // if n is negative, return 1/x raised to the power of absolute value of n
        if(n < 0)
            return myPow(1/x,Math.abs(n));

        // if n is even, return x raised to the power of n/2
        // if n is odd, return x*x raised to the power of n/2
        return (n % 2 == 0 ? myPow(x*x, n/2) : x * myPow(x*x, n/2));
    }
}
