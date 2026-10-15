class Solution {
    int[] dp; 
    public int minCostClimbingStairs(int[] cost) {
        dp = new int[cost.length];
        return Math.min(Math.min(cost[0]+mCCS(cost, 1), mCCS(cost, 2)+ cost[0]), 
        Math.min(cost[1]+mCCS(cost, 2), mCCS(cost, 3)+ cost[1]));
    }

    private int mCCS(int[] cost, int index){
        if(index >= cost.length) return 0;
        if(dp[index] > 0) return dp[index];
        
        return dp[index] = Math.min(cost[index]+mCCS(cost, index+1),   
            cost[index]+mCCS(cost, index+2));
    }
}
