class Solution {
    int[] dp;

     public int coinChange(int[] coins, int amount) {
        dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0]=0;

        for(int i=0; i<=amount; i++){
            for(int coin: coins){
                if(coin<=i){
                    dp[i] = Math.min(dp[i], dp[i-coin]+1);
                }
            }
        }

        return dp[amount]==amount+1 ? -1 : dp[amount];
     }

    // public int coinChangeDP(int[] coins, int amount) {
    //     // top-down
    //     if(amount<0) return - 1;
    //     if(amount==0) return 0;

    //     if (dp[amount] != -2) return dp[amount];

    //     int curr_min = Integer.MAX_VALUE;
    //     for(int coin: coins){
    //         int result = coinChangeDP(coins, amount - coin);

    //         if (result != -1) {
    //             curr_min = Math.min(curr_min, result + 1);
    //         }
    //     }

    //     return dp[amount] =
    //         (curr_min == Integer.MAX_VALUE) ? -1 : curr_min;
    // }
}
