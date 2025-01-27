class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // Create a list to hold the merged intervals
        List<int[]> list = new ArrayList<>();
        // Initialize a variable to keep track of the current interval being processed
        int i = 0;
        // Iterate through the intervals array
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            // Add intervals that come before the new interval to the list
            list.add(intervals[i++]);
        }
        // Merge overlapping intervals with the new interval
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            // Update the start and end of the new interval
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        // Add the new interval to the list
        list.add(newInterval);
        // Add the remaining intervals to the list
        while (i < intervals.length) {
            list.add(intervals[i++]);
        }
        // Convert the list to an array and return
        return list.toArray(new int[list.size()][]);
    }
}
