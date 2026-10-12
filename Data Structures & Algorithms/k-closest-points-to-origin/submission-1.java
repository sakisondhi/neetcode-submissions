class Entry{
    int distance;
    int[] point;

    Entry(int[] point){
        this.distance = point[0]*point[0] + point[1]*point[1] ;
        this.point = point;
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<Entry> maxHeap = new PriorityQueue<>(
            (a,b) -> Integer.compare(b.distance, a.distance)
        );

        for(int i=0; i<points.length; i++){
            Entry en = new Entry(points[i]);

            if(maxHeap.size() == k){
                maxHeap.offer(en);
                maxHeap.poll();
            }else{
                maxHeap.offer(en);
            }
        }

        int[][] res = new int[k][2];
        
        int i=0;
        while(!maxHeap.isEmpty()){
            int[] point = maxHeap.poll().point;
            res[i][0] = point[0];
            res[i][1] = point[1];
            i++;
        }

        return res;

    }
}
