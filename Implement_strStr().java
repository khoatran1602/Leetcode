class Solution {
  public int strStr(String haystack, String needle) {
    if (haystack.isEmpty() && needle.isEmpty()) {
      return 0;
    }
    int length = needle.length();
    if (haystack.contains(needle)) {
      int count = haystack.indexOf(needle);
      return count;
    } else {
      return -1;
    }
  }
}
