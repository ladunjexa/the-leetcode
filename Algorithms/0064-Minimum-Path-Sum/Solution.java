class Solution {
    public int minPathSum(int[][] grid) {
        int M = grid.length, N = grid[0].length;
        int[][] memo = new int[M + 1][N + 1];

        for(int i = 0; i < M; i++)
            Arrays.fill(memo[i], -1);
        
        return minPathSum(grid, 0, 0, memo, M, N);
    }

    private int minPathSum(int[][] grid, int i, int j, int[][] memo, int rows, int cols) {
        if(i >= rows || j >= cols)
            return Integer.MAX_VALUE;
        
        if(i == rows - 1 && j == cols - 1)
            return grid[i][j];
        
        if(memo[i][j] != -1)
            return memo[i][j];

        return memo[i][j] = grid[i][j] + Math.min(minPathSum(grid, i + 1, j, memo, rows, cols), minPathSum(grid, i, j + 1, memo, rows, cols));
    }
}
