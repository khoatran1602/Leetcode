class Solution {
  public int reverse(int x) {
    //Set b to long to contain all the possibilities
    long b = 0;               
    while (x != 0) {
      b = b * 10 + x % 10;
      x = x / 10l
      }
    if (b < Integer.MIN_VALUE || b > Integer.MAX_VALUE) {
      return 0;
    } else {
      return b;
    }
  }
}
--------------------------------------------------------------
public int reverse(int x) {
  String ans = x < 0 ? new StringBuilder(String.valueOf(-x)).append("-").reverse().toString()
    : new StringBuilder(String.valueOf(x)).reverse().toString();
  try {
    return Integer.parseInt(ans);
  } catch (Exception e) {
    return 0;
  }
}
------------------------------------------------------------------------------------------------

public void main() {
    int x = 123;
    int result = reverse(x);
    System.out.println(result);
}
