class Solution {
  public boolean isValid(String s) {
    if ((s.length() & 1) == 1) return false;
    else {
      Deque<Character> p = new ArrayDeque<>(s.length());
      for (int i = 0; i < s.length(); i++)
        switch (s.charAt(i)) {
          case '(': p.push(')'); break;
          case '{': p.push('}'); break;
          case '[': p.push(']'); break;
          case ')': case '}': case ']': if (p.isEmpty() || p.pop() != s.charAt(i)) return false;
        }
      return p.isEmpty();
    }
  }
}
------------------------------------------------------------------
