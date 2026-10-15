class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    q.add(new int[] { i, j });
                }
            }
        }
        if (q.size() == 0) return;

        int[][] dirs = { { -1, 0 }, { 0, -1 },
                         { 1, 0 }, { 0, 1 } };
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int row = node[0];
            int col = node[1];
            for (int[] dir : dirs) {
                int r = row + dir[0];
                int c = col + dir[1];
                if (r >= m || c >= n || r < 0 ||
                    c < 0 || grid[r][c] != Integer.MAX_VALUE) {
                    continue;
                }
                q.add(new int[] { r, c });

                grid[r][c] = grid[row][col] + 1;
            }
        }



        // int m = grid.length;
        // int n = grid[0].length;

        // for(int i=0; i<m; i++){
        //     for(int j=0; j<n; j++){
        //         if(grid[i][j] == 0) {
        //             dfs(grid, i+1, j, 1);
        //             dfs(grid, i, j+1, 1);
        //             dfs(grid, i-1, j, 1);
        //             dfs(grid, i, j-1, 1);
        //         }
        //     }
        // }
    }

    // private void dfs(int[][] grid, int x, int y, int distance){
    //     int m = grid.length;
    //     int n = grid[0].length;

    //     if(x<0 || y<0 || x==m || y==n) return;
    //     if(grid[x][y] == -1 || grid[x][y] == 0) return;
        
    //     // grid[x][y] = Math.min(distance, grid[x][y]);

    //     if(grid[x][y] <= distance) return;
    //     grid[x][y] = distance;

    //     dfs(grid, x+1, y, distance+1);
    //     dfs(grid, x, y+1, distance+1);
    //     dfs(grid, x-1, y, distance+1);
    //     dfs(grid, x, y-1, distance+1);
    // }
}
