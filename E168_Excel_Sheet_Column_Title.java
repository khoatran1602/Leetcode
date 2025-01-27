class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder word = new StringBuilder();
        
        while (columnNumber > 0) {
            columnNumber--;
            word.insert(0, (char) (columnNumber % 26 + 'A'));
            columnNumber = columnNumber / 26;
        }
        return word.toString();
    }
}
