class Solution {
  public int maxSubArray(int[] nums) {
    int realMax = Integer.MIN_VALUE;
    int fakeMax =  0;
    for (int num : nums) {
      fakeMax = fakeMax + num;
      if (realMax < fakeMax) {
        realMax = fakeMax;
      }
      if (fakeMax < 0) {
        fakeMax = 0;
      }
    }
    return realMax;
  }
}
