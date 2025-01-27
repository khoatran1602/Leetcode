class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int greed = 0;
        int child = 0;
        int count = 0;
        while (greed < g.length && child < s.length) {
            if (s[child] >= g[greed]) {
                count++;
                child++;
                greed++;
            } else {
                child++;
            }
        }
        return count;
    }
}
