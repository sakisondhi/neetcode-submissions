class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int islandCount = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    traverseDFS(grid, i, j);
                    islandCount++;
                }
            }
        }

        return islandCount;
    }

    private void traverseDFS(char[][] grid, int x, int y){
        int m = grid.length;
        int n = grid[0].length;

        if(x<0 || y<0 || x==m || y==n) return;

        if(grid[x][y] == '1'){
            grid[x][y] = 'Y';
            traverseDFS(grid, x+1, y);
            traverseDFS(grid, x, y+1);
            traverseDFS(grid, x-1, y);
            traverseDFS(grid, x, y-1);
        }

        return;
    }
}
