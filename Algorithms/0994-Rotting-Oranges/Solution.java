class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null | grid.length == 0)
            return -1;

        int N = grid.length, M = grid[0].length;
        
        for(int i = 0; i < N * M; i++)
            if(grid[i / M][i % M] == 2)
                orangesRotting(grid, i / M, i % M, 2);
            
        int min = 2;
        for(int i = 0; i < N * M; i++) {
            if(grid[i / M][i % M] == 1)
                return -1;
            min = Math.max(min, grid[i / M][i % M]);
        }

        return (min - 2);
    }

    private void orangesRotting(int[][] grid, int i, int j, int minutes) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || (1 < grid[i][j] && grid[i][j] < minutes))
            return ;
        grid[i][j] = minutes;
        orangesRotting(grid, i - 1, j, minutes + 1);
        orangesRotting(grid, i + 1, j, minutes + 1);
        orangesRotting(grid, i, j - 1, minutes + 1);
        orangesRotting(grid, i, j + 1, minutes + 1);
    }
}
