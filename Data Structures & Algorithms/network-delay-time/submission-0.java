class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] nodeTime = new int[n+1][n+1];

        for(int i=0; i<n+1; i++){
            for(int j=0; j<n+1; j++){
                nodeTime[i][j]=-1;
            }
        }

        // map the times in matrix
        for(int i=0; i<times.length; i++){
            nodeTime[times[i][0]][times[i][1]]=times[i][2];
        }

        // take a priority queue minHeap sorted by node val and distance
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> {
            int cmp = Integer.compare(a[1], b[1]); // Smaller distance first
    if (cmp == 0) {
        return Integer.compare(a[0], b[0]); // Tie: smaller index-0 value first
    }
    return cmp;
        });
        // take a int array of size n storing min distances with default value as MAX
        int[] minTime = new int[n+1];

        for(int i=0; i<n+1; i++){
            minTime[i] = Integer.MAX_VALUE;
        }
        minTime[k]=0;

        // add (k, 0) as starting in pq, then in a loop

        pq.add(new int[]{k, 0});
        // top od queue -> check all neighbors with their time and if new min time add, replce in array and add new entry in queue
        while(!pq.isEmpty()){
            int[] top = pq.poll();
            for(int i=1; i<=n; i++){
                if(nodeTime[top[0]][i] !=-1){
                    int neighbor = i;
                    if(minTime[neighbor]>minTime[top[0]] + nodeTime[top[0]][neighbor]){
                        minTime[neighbor]=minTime[top[0]] + nodeTime[top[0]][neighbor];
                        pq.add(new int[]{neighbor, minTime[neighbor]});
                    }
                }
            } 
        }
        // doing until queue is empty
        // traverse through array, return max value -> if MAX -> -1

        int res=-1;

        for(int i=1; i<n+1; i++){
            res = Math.max(minTime[i], res);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
