class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length - 2; i++){
            int lo = i + 1;
            int hi = nums.length - 1;
            while(lo < hi){
                int temp = nums[i] + nums[lo] + nums[hi];
                sum = Math.abs(target - sum) > Math.abs(target - temp) ? temp : sum; 
                if(temp == target) return temp;
                else if(temp > target) hi--;
                else if(temp < target) lo++;
            }          
        }
        return sum;
    }
}
