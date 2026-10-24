class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[amount+1][coins.length+1];
        for(int i=0; i<amount+1; i++){
            for(int j=0; j<coins.length+1; j++){
                dp[i][j]=-1;
            }
        }

        return dfs(amount, 0, coins, dp);
    }

    private int dfs(int amount, int index, int[] coins, int[][] dp){
        if(amount==0) return 1;

        if(amount<0) return 0;

        if(dp[amount][index]!=-1) return dp[amount][index];

        int combinations=0;
        for(int i=index; i<coins.length; i++){
            combinations+=dfs(amount-coins[i], i, coins, dp);
        }

        return dp[amount][index] = combinations;
    }
}
