class Solution {
    protected int max = 0, sum = 0;
    
    public int maxAreaOfIsland(int[][] grid) {
        for(int i = 0; i < grid.length; i++)
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] != 0) {
                    sum = 0;
                    DFS(grid, i, j);
                    max = Math.max(max, sum);
                }
            }
        
        return max;
    }

    private void DFS(int[][] grid, int row, int col) {
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0)
            return;
        
        sum++;
        grid[row][col] = 0;
        DFS(grid, row + 1, col);
        DFS(grid, row - 1, col);
        DFS(grid, row, col + 1);
        DFS(grid, row, col - 1);
    }
}
