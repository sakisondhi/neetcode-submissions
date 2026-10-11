class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'A']++;

            int maxFrequency = 0;
            for (int count : freq) {
                maxFrequency = Math.max(maxFrequency, count);
            }

            // Shrink until the window needs at most k replacements.
            while (right - left + 1 - maxFrequency > k) {
                freq[s.charAt(left) - 'A']--;
                left++;

                maxFrequency = 0;
                for (int count : freq) {
                    maxFrequency = Math.max(maxFrequency, count);
                }
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;



        
        // for(int i=0; i<s.length(); i++){
        //     int kTemp = k;
        //     for(int j=i+1; j<s.length(); j++){
        //         if(s.charAt(j) == s.charAt(i)){
        //             maxLength =  Math.max(maxLength, j-i+1);
        //             continue;
        //         }
        //         else if(kTemp>0){
        //             kTemp--;
        //             maxLength =  Math.max(maxLength, j-i+1);
        //         }
        //         else break;
        //     }
        // }
        // return maxLength;
    }
}
