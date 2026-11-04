class Solution {
    int maxCount = 0;
    String maxValue = "";
    public String longestPalindrome(String s) {
        for(int i=0; i<s.length(); i++){
            int left = i, right = i;
            traverse(s, left, right);
            right=i+1;
            traverse(s, left, right);
        }

        return maxValue;

    }

    private void traverse(String s, int left, int right){
        while(left>=0 && right<s.length()){
            if(s.charAt(left) == s.charAt(right)){
                if(right-left+1 > maxCount){
                    maxCount = Math.max(maxCount, right-left+1);
                    maxValue = s.substring(left, right+1);
                }
                left--;
                right++;
            }else break;
        }
    }
}
