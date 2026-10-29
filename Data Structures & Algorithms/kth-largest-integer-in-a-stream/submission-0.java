class KthLargest {
    Queue<Integer> q = new PriorityQueue<>();
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int i=0; i<nums.length; i++){
            q.offer(nums[i]);
            if(q.size()>k){
                q.remove();
            }
        }
    }
    
    public int add(int val) {
        q.offer(val);
        if(q.size()>k)
            q.remove();
        return q.peek();
    }
}
