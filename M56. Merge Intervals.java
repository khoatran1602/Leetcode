class Solution {
    public int[][] merge(int[][] intervals) {
       if (intervals.length < 2) return intervals;

        // Sort the intervals based on their start times
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Initialize a list to hold the merged intervals
        List<int[]> merged = new ArrayList<>();

        // Keep track of the current interval
        int[] current = intervals[0];

        // Iterate through the rest of the intervals
        for (int i = 1; i < intervals.length; i++) {
            // If the current interval overlaps with the next interval, merge them
            if (current[1] >= intervals[i][0]) {
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                // Otherwise, add the current interval to the list of merged intervals and start a new current interval
                merged.add(current);
                current = intervals[i];
            }
        }

        // Add the last current interval to the list of merged intervals
        merged.add(current);

        // Convert the list of merged intervals to an array
        return merged.toArray(new int[merged.size()][2]);
    }
}
