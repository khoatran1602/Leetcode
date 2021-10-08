class Solution {
    public int titleToNumber(String columnTitle) {
        char[] numbers = columnTitle.toCharArray();
        int result = 0;
        int length = numbers.length - 1;
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i] - 64;
            int number = num * (int) Math.pow(26, length--);
            result = result + number;
        }
        return result;
    }
}
