
class Solution {
    int[][] dp;

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;

        dp = new int[nums.length][2];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return dfs(nums, 0, 0);
    }

    private int dfs(int[] nums, int position, int firstTaken) {
        if (position >= nums.length) {
            return 0;
        }

        if (dp[position][firstTaken] != -1) {
            return dp[position][firstTaken];
        }

        // Option 1: Do not rob current house
        int skip = dfs(nums, position + 1, firstTaken);

        // Option 2: Rob current house
        int take = 0;

        // Cannot rob last house if first was robbed
        if (!(position == nums.length - 1 && firstTaken == 1)) {

            int newFirstTaken = firstTaken;

            if (position == 0) {
                newFirstTaken = 1;
            }

            take = nums[position]
                 + dfs(nums, position + 2, newFirstTaken);
        }

        dp[position][firstTaken] = Math.max(skip, take);

        return dp[position][firstTaken];
    }
}
