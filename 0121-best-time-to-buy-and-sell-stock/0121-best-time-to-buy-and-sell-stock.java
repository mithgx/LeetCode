class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int min = prices[0],profit = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int cost = prices[i] - min;
            min = Math.min(min,prices[i]);

            profit = Math.max(profit,cost);            
        }
        return profit;
    }
}