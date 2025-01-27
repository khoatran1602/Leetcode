class Solution {
    public boolean isPalindrome(int x) {
       if ( x < 0) {
            return false;
        }
      //Assign x = z so when we divide x by 10 later then we still have one more number to compare.
        int z = x;
        int y = 0;
        while (x != 0) {
            y = y * 10 + x % 10;
            x = x / 10;
        }
        if (z == 0 || z == y) {
            return true;
        } else {
            return false;
        }
    }
}
-----------------------------------------------------------------------------------------------------
class Solution {
  public boolean isPalindrome(int x) {
    String y = String.valueOf(x);
    int start = 0;
    int end = y.length() - 1;
    // We don't have to have "=" (start <= end) because when there is one number, it is palindrome.
    while (start < end) {
      if (y.charAt(start++) != y.charAt(end--)) return false;
    }
    return true;
  }
}
-------------------------------------------------------------------------------
