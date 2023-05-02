class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        // Create an ArrayList to store the intersection of intervals
        List<int[]> intersectionList = new ArrayList<>();
        int firstLength = firstList.length;
        int secondLength = secondList.length;
        int firstIndex = 0;
        int secondIndex = 0;
        int left = 0;
        int right = 0;
        // While there are intervals in both lists
        while (firstIndex < firstLength && secondIndex < secondLength) {
            // Find the maximum left endpoint and minimum right endpoint
            left = Math.max(firstList[firstIndex][0], secondList[secondIndex][0]);
            right = Math.min(firstList[firstIndex][1], secondList[secondIndex][1]);
            // If the intersection is not empty, add it to the intersectionList
            if (right >= left) intersectionList.add(new int[] {left, right});
            // Move the pointer to the next interval in the list whose endpoint is included in the intersection
            if (right == firstList[firstIndex][1]) firstIndex++;
            if (right == secondList[secondIndex][1]) secondIndex++;
        }
        // Convert the intersectionList to a 2D array and return it
        return intersectionList.toArray(new int[intersectionList.size()][]);
    }
}
