class Solution {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        leftMax[0] = height[0];
        rightMax[height.length-1] = height[height.length-1];
        for(int i= 1; i< height.length; i++){
            //leftMax
            leftMax[i] = Math.max(height[i], leftMax[i-1]);

            // rightMax
            int j= height.length-i-1;
            rightMax[j] = Math.max(height[j], rightMax[j+1]);
        }

        int totalWater = 0;
        for(int i= 0; i< height.length; i++){
            int minHeight = Math.min(leftMax[i], rightMax[i]);
            totalWater += (minHeight - height[i]);
        }

        return totalWater;
    }
}
