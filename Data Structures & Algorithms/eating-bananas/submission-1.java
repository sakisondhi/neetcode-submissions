class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxNumber=Integer.MIN_VALUE;

        for(int i=0; i<piles.length; i++){
            maxNumber = Math.max(maxNumber, piles[i]);
        }

        int left = 1, right = maxNumber;

        // int k = piles.length;
        int res = h;

        while(left<=right){
            int mid = left + (right-left)/2;

            long hcalc = calculateK(piles, mid);

            if(hcalc>h){
                left = mid+1;
            }else{
                res = mid;
                right = mid-1;
            }
        }

        return res;
    }

    private long calculateK(int[] piles, int mid){
        long total=0;
        
        for(int x: piles){
            int div = x/mid;
            int rem = x%mid;

            total = (rem==0) ? (total+div) : (total+div+1);
        }
        return total;
    }
}
