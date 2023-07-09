class Solution {
    public int numIslands(char[][] grid) {
        int M = grid.length, N = grid[0].length, c = 0;
        
        for(int i = 0; i < M; i++)
            for(int j = 0; j < N; j++) {
                if(grid[i][j] == '1')
                    c++;
                    DFS(grid, i, j);
            }
        
        return c;
    }

    private void DFS(char[][] grid, int r, int c) {
        if(grid[r][c] == '0')
            return;
        
        grid[r][c] = '0';
        if(r > 0)
            DFS(grid, r - 1, c);
        if(r < grid.length - 1)
            DFS(grid, r + 1, c);
        if(c > 0)
            DFS(grid, r, c - 1);
        if(c < grid[0].length - 1)
            DFS(grid, r, c + 1);
    }
}
