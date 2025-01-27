class Solution {
    public String toHex(int num) {
        if (num == -1) return "ffffffff";
        if (num == 0) return "0";
        int temp;  
        String hex = "";   
        char hexChars[] = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        if (num > 0) {
            while (num > 0) {
                temp = num % 16;
                hex = hexChars[temp] + hex;
                num = num / 16;
            }
        } else {
            long newNum =  (long) Math.pow(2, 32) + (long) num ;
            long newTemp = 0;
            while (newNum != 0) {
                newTemp = (newNum % 16);
                hex = hexChars[(int)newTemp] + hex;
                newNum = newNum / 16;
            }
        }
        return hex;
    }
}
