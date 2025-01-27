class Solution {
    public int maxProfit(int[] prices) {
        int maxPrice = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            //find the min price
            if (prices[i] < maxPrice) {
                maxPrice = prices[i];
            } else if (result < prices[i] - maxPrice) {
                //find the max price which after the min price
                result = prices[i] - maxPrice;
            }
        }
        return result;
    }
}
