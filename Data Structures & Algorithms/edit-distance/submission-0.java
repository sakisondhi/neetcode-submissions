class Solution {
    int[][] dp;
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n= word2.length();
        dp = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                dp[i][j]=-1;
            }
        }
        return dfs(word1, word2, 0, 0);
    }

    private int dfs(String word1, String word2, int x, int y){
        int m = word1.length(), n= word2.length();
        if(x==m){
            return (n-y);
        }
        if(y==n){
            return (m-x);
        }

        if(dp[x][y]!=-1) return dp[x][y];

        if(word1.charAt(x) == word2.charAt(y))
            return dp[x][y]=dfs(word1, word2, x+1, y+1);

        return dp[x][y]=Math.min(dfs(word1, word2, x, y+1) , Math.min(dfs(word1, word2, x+1, y), dfs(word1, word2, x+1, y+1))) +1;
    }
}
