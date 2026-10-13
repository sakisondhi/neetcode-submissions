class Solution {
    Integer[][] dp;

    public int lengthOfLIS(int[] nums) {
        dp = new Integer[nums.length][nums.length + 1];
        return dfs(nums, 0, -1);
    }

    private int dfs(int[] nums, int x, int prev) {
        if (x == nums.length) return 0;

        if (dp[x][prev + 1] != null) {
            return dp[x][prev + 1];
        }

        int skip = dfs(nums, x + 1, prev);
        int take = 0;

        if (prev == -1 || nums[x] > nums[prev]) {
            take = 1 + dfs(nums, x + 1, x);
        }

        return dp[x][prev + 1] = Math.max(take, skip);
    }
}


// class Solution {
//     int[] dp;
//     public int lengthOfLIS(int[] nums) {
//         dp = new int[nums.length+1];
//         return dp[0] = Math.max(dfs(nums, 1, nums[0]) + 1, dfs(nums, 1, -1001));
//     }

//     private int dfs(int[] nums, int x, int currentMax){
//         if(x==nums.length) return 0;
//         if(dp[x]>0) return dp[x];
//         if(nums[x] <= currentMax) return dfs(nums, x+1, currentMax);
//         return dp[x] = Math.max(dfs(nums, x+1, nums[x]) + 1, dfs(nums, x+1, currentMax));
//     }
// }
