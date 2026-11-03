class Solution {
    public int countSubstrings(String s) {
        int count=0;

        for(int i=0; i<s.length(); i++){
            //check odd
            count++;
            int left = i-1, right = i+1;

            while(left>=0 && right<s.length()){
                if(s.charAt(left) == s.charAt(right)) {
                    count++;
                    left--;
                    right++;
                }else break;
            }

            //check even
            left=i;
            right = i+1;
            while(left>=0 && right<s.length()){
                if(s.charAt(left) == s.charAt(right)){
                    count++;
                    left--;
                    right++;
                }else break;
            }
        }
        return count;
    }
}
