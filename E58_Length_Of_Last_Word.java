class Solution {
  public int lengthOfLastWord(String s) {
    int count = 0;
    int check = 0;
    //trim() method will cut off space at the first elements and the last elements.Ex: "  Hello World  " -> "Hello World"
    String a = s.trim();
    for (int i = a.length() - 1; i >= 0; i--) {
      if (a.charAt(i) == ' ') {
        break;
      } else {
        count++;
      }
    }
    if (count == 0) {
      for (int i = 0; i < a.length(); i++) {
        if (a.charAt(i) == ' ') {
          break;
        } else {
          check++;
        }
      }
    }
    return count == 0 ? check : count;
  }
}
