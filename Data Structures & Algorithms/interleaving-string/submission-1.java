class Solution {
    int[][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length(), o = s3.length();
        dp = new int[m][n];
        if(o != m + n) return false;

        return dfs(s1, 0, s2, 0, s3);
    }

    private boolean dfs(String s1, int x, String s2, int y, String s3){
        int m = s1.length(), n = s2.length(), o = s3.length();
        int index = x+y;

        if(index == o) return true;

        if(x==m){
            if(s3.substring(index, o).equals(s2.substring(y, n))) 
                return true;
            return false;
        }

        if(y==n){
            if(s3.substring(index, o).equals(s1.substring(x, m))) 
                return true;
            return false;
        }

        if(dp[x][y]!=0){
            if(dp[x][y]==1) return false;
            return true;
        }

        boolean takeS1 = false, takeS2 = false;

        if (s1.charAt(x) == s3.charAt(index))
            takeS1 = dfs(s1, x+1, s2, y, s3);

        if (s2.charAt(y) == s3.charAt(index))
            takeS2 = dfs(s1, x, s2, y+1, s3);

        dp[x][y] = (takeS1 || takeS2) ? 2 : 1 ;
        return takeS1 || takeS2;
    }
}
