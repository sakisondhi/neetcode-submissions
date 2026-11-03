class Solution {
    int[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new int[s.length()];
        for(int i=0; i<s.length(); i++) dp[i]=-1;
        return dfs(s, wordDict, 0);
    }

    private boolean dfs(String s, List<String> wordDict, int startIndex){
        // if(startIndex>s.length()) return false;

        if(startIndex==s.length()) return true;

        if(dp[startIndex]==1) return true;
        if(dp[startIndex]==0) return false;

        for(int i=0; i<wordDict.size(); i++){
            String sT = wordDict.get(i);
            if (sT.length() <= s.length() - startIndex) {
                if (s.substring(startIndex, startIndex + sT.length()).equals(sT)) {
                    if (dfs(s, wordDict, startIndex + sT.length())) {
                        dp[startIndex]=1;
                        return true;
                    }
                }
            }
        }
        dp[startIndex]=0;
        return false;
    }
}
