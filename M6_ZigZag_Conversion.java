class Solution {
    public String convert(String s, int numRows) {
        char[] c = s.toCharArray();
        int length = c.length;
        int count = 0;
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder();
        }
        while (count < length) {
            for (int i = 0; i < numRows && count < length; i++) sb[i].append(c[count++]);
            for (int i = numRows - 2; i >= 1 && count < length; i--) sb[i].append(c[count++]);
        }
        
        for (int i = 1; i < sb.length; i++) {
            sb[0].append(sb[i]);
        }
        
        return sb[0].toString();
    }
}
-------------------------------------------------------------
