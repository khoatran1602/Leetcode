class Solution {
    public int romanToInt(String s) {
     int a = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'I':
                    a = a + 1;
                    break;
                case 'V':
                    a = a + 5;
                    break;
                case 'X':
                    a = a + 10;
                    break;
                case 'L':
                    a = a + 50;
                    break;
                case 'C':
                    a = a + 100;
                    break;
                case 'D':
                    a = a + 500;
                    break;
                case 'M':
                    a = a + 1000;
                    break;
            }
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == 'I' && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')) {
                a = a - 2;
            } else if ((s.charAt(i) == 'X' && (s.charAt(i + 1) == 'L') || s.charAt(i + 1) == 'C')) {
                a = a - 20;
            } else if ((s.charAt(i) == 'C' && (s.charAt(i + 1) == 'D') || s.charAt(i + 1) == 'M')) {
                a = a - 200;
            }
        }
        return a;
    }
}
