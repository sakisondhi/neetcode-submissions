class Solution {
    List<Integer> sol;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        sol= new ArrayList<>();

        for (int[] arr : prerequisites) {
            graph.computeIfAbsent(arr[1], key -> new ArrayList<>())
                 .add(arr[0]);
        }

        int[] visited = new int[numCourses];

        for (int course = 0; course < numCourses; course++) {
            if (visited[course] == 0 &&
                !dfs(graph, visited, course)) {
                return new int[0];
            }
        }

        int[] arr = new int[sol.size()];

        Collections.reverse(sol);

        for (int i = 0; i < sol.size(); i++) {
            arr[i] = sol.get(i); // Automatically unboxes Integer → int
        }

        return arr;
    }

    private boolean dfs(
        Map<Integer, List<Integer>> graph,
        int[] visited,
        int currentNode
    ) {
        if (visited[currentNode] == 1) return false; // Cycle
        if (visited[currentNode] == 2) return true;  // Already checked

        visited[currentNode] = 1;

        for (int neighbour :
             graph.getOrDefault(currentNode, Collections.emptyList())) {
            if (!dfs(graph, visited, neighbour)) {
                return false;
            }
        }

        visited[currentNode] = 2;
        sol.add(currentNode);
        return true;
    }
}
