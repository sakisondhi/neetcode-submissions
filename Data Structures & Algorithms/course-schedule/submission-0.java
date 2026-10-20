class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> graph = new HashMap<>();

        for(int[] arr: prerequisites){
            List<Integer> li = graph.getOrDefault(arr[1], new ArrayList<>());
            li.add(arr[0]);
            graph.put(arr[1], li);
        }

        int[] visited = new int[numCourses];

        for (int course = 0; course < numCourses; course++) {
            if (visited[course] == 0 &&
                !dfs(graph, visited, course)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(Map<Integer,List<Integer>> graph, int[] visited, int currentNode){
        if(visited[currentNode]==1) return false;
        if (visited[currentNode] == 2) return true; 

        visited[currentNode] = 1;

        List<Integer> neighbours = graph.get(currentNode);

        for(int neighbour :
             graph.getOrDefault(currentNode, Collections.emptyList())){
            if(!dfs(graph, visited, neighbour)) return false;
        }

        visited[currentNode] = 2;
        return true;

    }
}
