class Solution {
    static Map<Character,String> map = new HashMap<>();
    static {
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
    }
    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;
        //If the length is 1 then return the res
        //If the length > 1, then we add the characters of last number (example: 23, then the last number is 3) to the temp list
        if (digits.length() == 1) {
            String s = map.get(digits.charAt(0));
            for (int i = 0; i < s.length(); i++) {
                res.add(s.charAt(i) + "");
            }
            return res;
        }
        //Use recursion here. If the digits is "234", the the first recursion is 34, then the second recursion is 4, then it moves up the 
        //if (digits.length == 1) above
        //to add to characters to the temp list
        List<String> temp = letterCombinations(digits.substring(1, digits.length()));
        //The second recursion will be done from here
        String s = map.get(digits.charAt(0));
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < temp.size(); j++) {
                res.add(s.charAt(i) + temp.get(j));
            }
        }
        return res;
    }
}
