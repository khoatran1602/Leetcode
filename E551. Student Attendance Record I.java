class Solution {
    public boolean checkRecord(String s) {
        int absent = 0;
        int late = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') absent = absent + 1;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (late == 2) break;
            if (s.charAt(i) == 'L' && s.charAt(i + 1) == 'L') {
                late = late + 1;
            } else {
                late = 0;
            }
        }
        if (absent > 1 || late >= 2) return false;
        return true;
    }
}

class Solution {
    public boolean checkRecord(String s) {

        int c = 0;                   //to keep count of A's
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                c++;
            }
        }

        if (c < 2)    //checks condition 1
        {
            if (!s.contains("LLL"))        //checks condition 2
            {
                return true;
            }
        }

        return false;
    }
}
