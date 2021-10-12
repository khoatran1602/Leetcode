public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int num = 0;
        for (int i = 0; i < 32; i++) {
            num <<= 1; //Move the bit to the right
            num |= (n & 1); // Compare the last bit of n and num to each other
            n >>= 1; //Move the bit to the left
        }
        return num;
    }
}
