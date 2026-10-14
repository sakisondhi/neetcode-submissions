class Solution {
    public int lastStoneWeight(int[] stones) {
        
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i=0; i<stones.length; i++){
            maxHeap.offer(stones[i]);
        }

        while(maxHeap.size()>=2){
            maxHeap.offer(maxHeap.poll() - maxHeap.poll());
        }

        return maxHeap.poll();

    }
}
