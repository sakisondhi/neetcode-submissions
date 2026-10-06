class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length-1;
        int maxArea = 0;
        
        while(left<right){
            int currMax = Math.min(heights[left], heights[right]) * (right-left) ;

            maxArea = Math.max(maxArea, currMax);
            if (heights[left] <= heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    // private int maxAreaCal(int[] heights, int left, int right){
    //     if(left>=right) return 0;
    //     int currMax = Math.min(heights[left], heights[right]) * (right-left) ;

    //     return Math.max(currMax, Math.max(maxAreaCal(heights, left, right-1), maxAreaCal(heights, left+1, right)));
    // }
}
