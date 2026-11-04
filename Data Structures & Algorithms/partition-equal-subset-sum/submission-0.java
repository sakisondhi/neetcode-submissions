class Solution {
    int[][] dp;
    public boolean canPartition(int[] nums) {
        dp = new int[101][2500];
        int sum = 0;
        for(int n : nums){
            sum+=n;
        }
        if(sum%2 == 1) return false;

        return dfs(nums, sum/2, 0, 0);
    }

    private boolean dfs(int[] nums, int target, int x, int currentSum){
        if(currentSum == target) return true;
        if(x==nums.length || currentSum>target) return false;

        if(dp[x][currentSum]==2) return true;
        else if(dp[x][currentSum]==1) return false;

        boolean ans = (dfs(nums, target, x+1, currentSum + nums[x]) 
                || dfs(nums, target, x+1, currentSum));

        dp[x][currentSum] = (ans) ? 2 : 1;

        return ans;
    }
}
