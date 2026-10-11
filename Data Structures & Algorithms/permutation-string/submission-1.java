class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        char[] s1Arr = s1.toCharArray();
        Arrays.sort(s1Arr);

        for(int i=0; i<=s2.length()-s1.length(); i++){
            char[] s2SubStrArr = s2.substring(i,i+s1.length()).toCharArray();
            Arrays.sort(s2SubStrArr);

            // compare two arrays
            if(Arrays.equals(s1Arr, s2SubStrArr)) return true;
        }
        return false;
    }
}
