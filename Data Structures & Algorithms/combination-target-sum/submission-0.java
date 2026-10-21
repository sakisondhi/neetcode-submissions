class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();

        List<Integer> li = new ArrayList<>();

        dfs(nums, target, 0, li);
        return res;
    }

    public void dfs(int[] nums, int target, int index, List<Integer> li){
        if(target < 0) return;

        if(target == 0){
            List<Integer> copy = new ArrayList<>(li);
            res.add(copy);
            return;
        }

        for(int i=index; i<nums.length; i++){
            li.add(nums[i]);
            dfs(nums, target-nums[i], i, li);
            li.remove(li.size() - 1);
        }

        return;
    }
}
