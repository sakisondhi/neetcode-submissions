class Solution {
    int[] dp;
    public int numDecodings(String s) {
        dp = new int[s.length()+1];
        for(int i=0; i<dp.length; i++) dp[i]=-1;
        return dfs(s, 0);
    }

    private int dfs(String s, int x){
        if(x>=s.length()) return 1;

        if (s.charAt(x) == '0') return 0;

        if(dp[x]!=-1) return dp[x];

        // Option 1: Decode one digit
        int count = dfs(s, x + 1);

        // Option 2: Decode two digits
        if (x + 1 < s.length()) {
            int num = Integer.parseInt(s.substring(x, x + 2));

            if (num >= 10 && num <= 26) {
                count += dfs(s, x + 2);
            }
        }

        return dp[x]=count;
    }
}
