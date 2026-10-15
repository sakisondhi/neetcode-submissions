class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[n - 1] = true;

        for (int i = n - 2; i >= 0; i--) {
            int maxJump = Math.min(nums[i], n - 1 - i);

            for (int jump = 1; jump <= maxJump; jump++) {
                if (dp[i + jump]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[0];
    }
}
