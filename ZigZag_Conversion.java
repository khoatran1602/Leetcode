public String convert(String s, int numRows) {
  if (numRows == 1) return s;
  int interval = (numRows - 1) * 2;
  StringBuilder sb = new StringBuilder();
  for (int i = 0; i < numRows; i++) {
    int j = i;
    while (j < s.length()) {
      sb.append(s, j, j + 1);
      int k = j + interval - 2 * i;
      if (i != 0 && i != numRows - 1 && k < s.length()) {
        sb.append(s, k, k + 1);
      }
      j += interval;
    }
  }
  return sb.toString();
}
