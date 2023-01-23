class KthLargest {
    final PriorityQueue<Integer> queue; // create a priority queue
    final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k; // keep track of k
        queue = new PriorityQueue<>(k); // initialize the priority queue with k elements
        for (int num : nums) { //iterate through the array
            add(num); // add the element to the queue
        }
    }

    public int add(int val) {
        if (queue.size() < k) queue.offer(val); // if size of queue is less than k, add the element to the queue
        else if (queue.peek() < val) { // if the top of the queue is less than the new element
            queue.poll(); // remove the top element
            queue.offer(val); // add the new element
        }
        return queue.size() == k ? queue.peek() : -1; // return the kth largest element
    }
}


/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
