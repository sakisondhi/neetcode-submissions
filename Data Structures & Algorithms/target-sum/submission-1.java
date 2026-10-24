class Solution {
    int target, offset;
    int[][] dp;
    public int findTargetSumWays(int[] nums, int target) {
        this.target = target;
        for (int num : nums) {
            offset += num;
        }

        if (target > offset || target < -offset) {
            return 0;
        }

        dp = new int[nums.length][2 * offset + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return dfs(nums, 0, 0);
    }

    private int dfs(int[] nums, int pos, int sum){
        if (pos == nums.length) {
            return sum == target ? 1 : 0;
        }

        // Already calculated
        if (dp[pos][sum + offset] != -1) {
            return dp[pos][sum + offset];
        }

        int add = dfs(nums, pos+1, sum-nums[pos]);
        int subtract = dfs(nums, pos+1, sum+nums[pos]);

        dp[pos][sum + offset] = subtract + add;

        return dp[pos][sum + offset];
    }
}
