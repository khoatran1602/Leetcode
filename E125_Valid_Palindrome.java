class Solution {
    public boolean isPalindrome(String s) {
        String newS = s.replaceAll("[^a-zA-Z0-9]+", "");
        String result = newS.toLowerCase();
        System.out.println(result);
        int length = result.length() - 1;
        int count = 0;
        if (result.length() <= 1) {
            return true;
        }
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) == result.charAt(length)) {
                count++;
                length--;
            } else {
                break;
            }
        }
        if (count == result.length()) {
            return true;
        } else {
            return false;
        }
    }
}
