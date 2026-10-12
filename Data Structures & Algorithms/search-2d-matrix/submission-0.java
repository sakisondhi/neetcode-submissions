class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length; 
        int n = matrix[0].length; 

        int i = 0, j = m*n - 1; 

        while(i<=j){
            int mid = i + (j-i)/2; 
            int actualMidI = mid/n; 
            int actualMidJ = mid%n; 

            if(matrix[actualMidI][actualMidJ] == target) return true;
            else if(matrix[actualMidI][actualMidJ] < target){
                i = mid+1; 
            }else{
                j = mid-1; 
            }
        }
        return false;
    }
}
