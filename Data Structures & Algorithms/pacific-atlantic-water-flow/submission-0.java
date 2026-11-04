class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] pacific = new int[m][n];

        int[][] visited = new int[m][n];

        int[][] atlantic = new int[m][n];

        for(int i=0; i<m; i++){
            int j=0;
            // pacific[i][j]=1;
            dfs(heights, i, j, visited, pacific, -1);

            j=n-1;
            // atlantic[i][j]=1;
            dfs(heights, i, j, visited, atlantic, -1);
        }

        for(int i=0; i<n; i++){
            int j=0;
            // pacific[j][i]=1;
            dfs(heights, j, i, visited, pacific, -1);

            j=m-1;
            // atlantic[j][i]=1;
            dfs(heights, j, i, visited, atlantic, -1);
        }

        List<List<Integer>> res = new ArrayList<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(atlantic[i][j]==1 && pacific[i][j]==1){
                    List<Integer> li = new ArrayList();
                    li.add(i);
                    li.add(j);
                    res.add(li);
                }
            }
        }
        return res;
        
    }

    private void dfs(int[][] heights, int x, int y, int[][] visited, int[][] visitArray, int prevHeight){
        int m = heights.length, n = heights[0].length;
        if(x>=m || y>=n || x<0 || y<0) return;

        if(visited[x][y] == 1 || heights[x][y] < prevHeight){
            return;
        }

        visited[x][y]=1;
        visitArray[x][y]=1;
        dfs(heights, x+1, y, visited, visitArray, heights[x][y]);
        dfs(heights, x, y+1, visited, visitArray, heights[x][y]);
        dfs(heights, x-1, y, visited, visitArray, heights[x][y]);
        dfs(heights, x, y-1, visited, visitArray, heights[x][y]);
        visited[x][y]=0;

        return;
    }
}
