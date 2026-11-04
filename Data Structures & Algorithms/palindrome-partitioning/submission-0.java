class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        traverse(s, 0, 0, new ArrayList<>());

        return res;
    }

    private void traverse(String s, int prev, int current, List<String> ls){
        if (prev == s.length()) {
            res.add(new ArrayList<>(ls));
            return;
        }
        if (current == s.length()) return;

        String str = s.substring(prev, current + 1);

        // Choice 1: Partition here
        if (isPalindrome(str)) {
            ls.add(str);
            traverse(s, current + 1, current + 1, ls);
            ls.remove(ls.size() - 1);
        }

        // Choice 2: Expand current substring
        traverse(s, prev, current + 1, ls);
    }

    private boolean isPalindrome(String s){
        int left = 0, right = s.length()-1;

        while(left<=right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
