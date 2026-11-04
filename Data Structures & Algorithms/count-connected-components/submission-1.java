class Solution {
    int[] parent;

    public int countComponents(int n, int[][] edges) {
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int count = n;

        for (int[] edge : edges) {
            int x = find(edge[0]);
            int y = find(edge[1]);

            if (x != y) {
                parent[y] = x;
                count--;
            }
        }

        return count;
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}