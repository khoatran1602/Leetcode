class MedianFinder {
    // Priority queues to store the elements
    private final PriorityQueue<Integer> maxHeap;  // Stores smaller half of the numbers
    private final PriorityQueue<Integer> minHeap;  // Stores larger half of the numbers
    private boolean isEven;  // Flag to keep track of whether the number of elements is even or odd

    public MedianFinder() {
        // Initialize the priority queues and flag
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
        isEven = true;
    }

    public void addNum(int num) {
        if (isEven) {
            // If the number of elements is even, add to maxHeap first
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        } else {
            // If the number of elements is odd, add to minHeap first
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
        // Toggle the flag to keep track of even or odd count
        isEven = !isEven;
    }

    public double findMedian() {
        if (isEven) {
            // If the number of elements is even, return the average of the two middle elements
            return (double) (minHeap.peek() + maxHeap.peek()) / 2;
        } else {
            // If the number of elements is odd, return the middle element
            return minHeap.peek();
        }
    }
}


/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
