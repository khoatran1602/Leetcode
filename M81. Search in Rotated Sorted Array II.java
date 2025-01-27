class Solution {
    public boolean search(int[] nums, int target) {
        for (int num : nums) {
            if (num == target) return true;
        }
        return false;
    }
}

class Solution {
    public boolean search(int[] nums, int target) {
        // Initialize left and right pointers to first and last indices of the array
        int left = 0, right = nums.length - 1;
        
        // Binary search loop
        while (left <= right) {
            // Calculate the middle index of the current search range
            int mid = (left + right) / 2;
            
            // If the middle value is the target, return true
            if (nums[mid] == target) {
                return true;
            }
            
            // If the left, middle, and right values are all the same, move left and right pointers inward
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            } 
            // If the left half of the search range is sorted and the target is in that half, move the right pointer inward
            else if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } 
            // If the right half of the search range is sorted and the target is in that half, move the left pointer inward
            else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        // If the target is not found, return false
        return false;
    }
}
