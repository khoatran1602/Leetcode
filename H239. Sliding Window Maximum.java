class Solution {
    public int[] maxSlidingWindow(int[] nums, int w) {     
        // Get the length of the input array
        int len = nums.length;
        // Initialize the result array with length (n - windowSize + 1)
        int[] result = new int[len - w + 1];
        // Create a deque to store the indices of elements in the current window
        Deque<Integer> deque = new LinkedList<>();
        
        // Iterate through the input array
        for (int i = 0; i < len; i++) {
            // Remove the indices of elements outside of the current window from the deque
            while (!deque.isEmpty() && deque.peek() < i - w + 1) {
                deque.poll();
            }
            
            // Remove the indices of elements smaller than the current element from the deque
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            
            // Add the current index to the deque
            deque.offer(i);
            
            // Add the maximum element in the current window to the result array
            if (i - w + 1 >= 0) {
                result[i - w + 1] = nums[deque.peek()];
            }
        }
        
        // Return the result array
        return result;
    }
}
