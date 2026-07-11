class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0], profit, maxProfit = 0;
        for(int i = 1; i <= prices.length-1; i++){
            if (min > prices[i]){
                min = prices [i];
                continue;
            }
            profit = prices[i] - min;
            if( profit > maxProfit)
                maxProfit = profit;
        }
        return maxProfit;
    }
}
