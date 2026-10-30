class Solution {
    int[][] visited;
    public boolean exist(char[][] board, String word) {
        visited = new int[board.length][board[0].length];
        boolean res;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                res = dfs(board, word, i, j, 0);
                if(res) return res;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int x, int y, int targetIndex){
        if(targetIndex == word.length()) return true;

        if(x<0 || y<0 || x==board.length || y==board[0].length || visited[x][y]==1 
            || board[x][y]!=word.charAt(targetIndex)) 
            return false;

        

        visited[x][y]=1;

        boolean res = dfs(board, word, x+1, y, targetIndex+1) ||
                dfs(board, word, x-1, y, targetIndex+1) ||
                dfs(board, word, x, y+1, targetIndex+1) ||
                dfs(board, word, x, y-1, targetIndex+1);

        visited[x][y]=0;

        return res;
    }
}
