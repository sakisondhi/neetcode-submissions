class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();

        int m = grid.length;
        int n = grid[0].length;
        int countFresh = 0;
        int minutes = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    countFresh++;
                } else if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        int[][] directions = {
            {1, 0},   // Down
            {-1, 0},  // Up
            {0, 1},   // Right
            {0, -1}   // Left
        };

        while (!q.isEmpty() && countFresh > 0) {
            int size = q.size();

            // Process only the oranges present at this minute's start.
            for (int i = 0; i < size; i++) {
                int[] cell = q.poll();
                int x = cell[0];
                int y = cell[1];

                for (int[] dir : directions) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];

                    if (nx < 0 || nx >= m || ny < 0 || ny >= n
                            || grid[nx][ny] != 1) {
                        continue;
                    }

                    grid[nx][ny] = 2;
                    countFresh--;
                    q.offer(new int[]{nx, ny});
                }
            }

            minutes++;
        }

        return countFresh == 0 ? minutes : -1;
    }
}