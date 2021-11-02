class NumArray {
    private int[] arr;
    public NumArray(int[] nums) {
        this.arr = new int[nums.length];
        this.arr[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            this.arr[i] = this.arr[i-1] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        if (left == 0) {
            return this.arr[right];
        } else if (left < 0 || right < 0 || right > this.arr.length || left > this.arr.length) {
            return -1;
        }
        return this.arr[right] - this.arr[left - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
