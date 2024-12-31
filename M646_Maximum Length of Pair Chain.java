import java.util.HashSet;

class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
        System.out.println(Arrays.deepToString(pairs));
        int[] temp = new int[pairs.length];
        int threshold = pairs[0][1];
        temp[0] = pairs[0][1];
        int len = 1;
        for (int i = 1; i < pairs.length; i++) {
            System.out.println("Threshold: " + threshold);
            System.out.println("Pairs[i][0]: " + pairs[i][0]);
            if (pairs[i][0] > threshold) {
                temp[len++] = pairs[i][1];
                threshold = pairs[i][1];
            }
        }
        System.out.println("Length: " + len);
        System.out.println(Arrays.toString(temp));
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < temp.length; i++) {
            set.add(temp[i]);
        }
        set.remove(0);
        return set.size();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] pairs = {{1,2}, {2,3}, {3,4}};
        System.out.println(sol.findLongestChain(pairs));
    }
}