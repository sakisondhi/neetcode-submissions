class Solution {
    int[] dp;
    public int climbStairs(int n) {
        dp = new int[n+1];
         
        return dpClimbStairs(n);
    }

    private int dpClimbStairs(int n){
        if(n<0) return 0;
        if(n==0) return 1;
        if(dp[n] > 0) return dp[n];
        

        dp[n] = dpClimbStairs(n-1) + dpClimbStairs(n-2);
        return dp[n];
    }
}
