class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            // If the prices array is empty, there is no profit to be made
            return 0;
        }
        
        int maxProfit = 0;
        int buyingPrice = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int profit = 0;
            if (prices[i] < prices[i + 1]) {
                buyingPrice = prices[i];
                for (int j = i + 1; j < prices.length; j++) {
                    if (j != prices.length - 1) {
                        if (prices[j] > prices[j + 1]) {
                            // If the price starts decreasing, sell the stock and calculate the profit
                            profit += prices[j] - buyingPrice;
                            i = j;
                            break;
                        } else if (prices[j] < prices[j + 1]) {
                            // If the price continues to increase, update the selling price
                            profit += prices[j + 1] - buyingPrice;
                            i = j;
                            break;
                        }
                    } else {
                        // If we have reached the end of the array, sell the stock and calculate the profit
                        profit += prices[j] - buyingPrice;
                        i = j;
                        break;
                    }
                }
            }
            maxProfit += profit;
        }
        return maxProfit;
    }
}
