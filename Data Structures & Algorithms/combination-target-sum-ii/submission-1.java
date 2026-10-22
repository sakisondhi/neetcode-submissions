class Solution {
    List<List<Integer>> combinations = new ArrayList<>();
    Set<List<Integer>> combinationsSet = new HashSet<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> li = new ArrayList<>();
        dfs(candidates, target, 0, li);

        return new ArrayList<>(combinationsSet);
    } 

    private void dfs(int[] candidates, int target, int startIndex, List<Integer> li){
        if(target==0){
            List<Integer> liCopy = new ArrayList<>(li);
            combinationsSet.add(liCopy);
            return;
        }
        if(target<0 || startIndex == candidates.length) return;
        

        for(int i=startIndex; i<candidates.length; i++){
            if (i > startIndex && candidates[i] == candidates[i - 1]) continue;

            li.add(candidates[i]);
            dfs(candidates, target-candidates[i], i+1, li);
            li.remove(li.size()-1);
        }

        return;
    }
}
