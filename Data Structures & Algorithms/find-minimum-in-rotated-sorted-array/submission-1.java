class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length-1;
        int res = nums[l];

        while(l <= r){
            if(nums[l] < nums[r]) return Math.min(nums[l], res);

            int mid = l+(r-l)/2;

            res = Math.min(nums[mid], res);
            if(nums[mid]> nums[r]){
                l = mid+1;
            }else r = mid-1;
        }

        return res;
    }
}
