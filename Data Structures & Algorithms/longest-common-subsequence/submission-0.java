class Solution {
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        dp = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                dp[i][j]=-1;
            }
        }

        return dfs(text1, text2, 0, 0);
    }

    private int dfs(String t1, String t2, int x, int y){
        int m = t1.length(), n = t2.length();
        if(x==m || y==n) return 0;

        if(t1.charAt(x) == t2.charAt(y)) 
            return dp[x][y] = 1 + dfs(t1, t2, x+1, y+1);

        if(dp[x][y]!=-1) return dp[x][y];

        return dp[x][y] = Math.max( dfs(t1, t2, x+1, y), Math.max(dfs(t1, t2, x, y+1), dfs(t1, t2, x+1, y+1)) );
    }
}
