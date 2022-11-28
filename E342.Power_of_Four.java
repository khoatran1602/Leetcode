class Solution {
    public boolean isPowerOfFour(int n) {
        if(n < 1) return false;
        if (n % 4 == 0) return isPowerOfFour(n/4);
        return n == 1;
        //public boolean isPowerOfFour(int num) {
        //return (Math.log(num) / Math.log(4)) % 1 == 0;
    }
}
