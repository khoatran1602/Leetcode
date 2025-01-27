class Solution {
    public String[] findRelativeRanks(int[] score) {
        int index = 1;
        String[] res = new String[score.length];
        Map<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < score.length; i++) {
            map.put(score[i], i);
        }
        for (Integer value : map.values()) {
            res[value] = String.valueOf(index);
            index++;
        }
        for (int i = 0; i < res.length; i++) {
            if (res[i].equals("1")) {
                res[i] = "Gold Medal";
            }
            if (res[i].equals("2")) {
                res[i] = "Silver Medal";
            }
            if (res[i].equals("3")) {
                res[i] = "Bronze Medal";
            }
        }
        return res;
    }
}
