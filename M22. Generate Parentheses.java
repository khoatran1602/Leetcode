class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if (n <= 0) {
            return res;
        }
        
        dfs(res, "", n, 0);
        
        return res;
    }
    
    public void dfs(List<String> res, String s, int n, int count) {
        if (n == 0 && count == 0) {
            res.add(s);
            return;
        }
        if (n < 0) {
            return;
        }
        if (count < 0) {
            return;
        }
        
        dfs(res, s + "(", n - 1, count + 1);
        dfs(res, s + ")", n, count - 1);
        
        return;
    }
}
