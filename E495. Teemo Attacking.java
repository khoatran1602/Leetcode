class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int res = duration;
        if (timeSeries.length == 1) {
            return duration;
        }
        if (duration == 0) return 0;
        for (int i = 1; i < timeSeries.length; i++) {
            int diff = timeSeries[i] - timeSeries[i-1];
            res = res + (Math.min(diff, duration));
        }
        return res;
    }
}
