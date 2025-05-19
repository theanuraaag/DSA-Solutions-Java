// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

class Solution {
   
    public int maxProfit(int[] prices) {
        if(prices.length<2) return 0;
        int minPrice = prices[0];
        int profit = prices[1]- prices[0];
        for(int i=0;i<prices.length;i++)
        {
            profit = Math.max(profit,prices[i]-minPrice);
            minPrice = Math.min(minPrice,prices[i]);
        }
        return profit;
    }
}

// Time Complexity : O(N)
// Space Complexity : O(1)