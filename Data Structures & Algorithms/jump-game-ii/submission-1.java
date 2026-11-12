class Solution {
    public int jump(int[] nums) {
        int lastPos = nums.length - 1;
        nums[lastPos] = 0;

        for(int i=lastPos-1; i>=0; i--){
            if(i+nums[i] >= lastPos) nums[i]=1;
            else{
                int minD = lastPos+1;
                for(int j=i+nums[i]; j>i; j--){
                    minD = Math.min(minD, nums[j]);
                }
                nums[i]=minD+1;
            }
        }

        return nums[0];
    }
}
