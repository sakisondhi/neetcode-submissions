class Solution {
    private Integer[][] dp;
    
    public int maxProfit(int[] prices) {

        if(prices.length==1) return 0;
        dp = new Integer[2][prices.length];
        return Math.max(calMaxProfit(false, prices, 1), -1*prices[0]+calMaxProfit(true, prices, 1));
    }
    

    public int calMaxProfit(boolean buyFlag, int[] prices, int nextIndex){
        if(nextIndex>=prices.length) return 0;
        
        int state = buyFlag ? 1 : 0;

        if (dp[state][nextIndex] != null) {
            return dp[state][nextIndex];
        }

        int skip = calMaxProfit(
            buyFlag, prices, nextIndex + 1
        );

        if(buyFlag){
            int sell = prices[nextIndex]
                + calMaxProfit(false, prices, nextIndex + 2);

            dp[state][nextIndex] = Math.max(skip, sell);
        } else {
            int buy = -prices[nextIndex]
                + calMaxProfit(true, prices, nextIndex + 1);

            dp[state][nextIndex] = Math.max(skip, buy);
        }

        return dp[state][nextIndex];
    }
}
