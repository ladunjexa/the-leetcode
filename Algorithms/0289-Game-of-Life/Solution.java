class Solution {
    private final int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    private final int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    public void gameOfLife(int[][] board) {
        int M = board.length, N = board[0].length, x = 0;
        int[][] source = new int[M][N];

        for (int[] v : board)
            source[x++] = v.clone();
        
        for(int i = 0; i < M * N; applyRules(board, source, i / N, i++ % N));
    }

    private void applyRules(int[][] grid, int[][] source, int i, int j) {
        int neighbors = countLiveNeighbors(source, i, j);

        if(neighbors == 3)
            grid[i][j] = 1;
        else if(neighbors != 2)
            grid[i][j] = 0;
    }

    private int countLiveNeighbors(int[][] grid, int i, int j, boolean skip) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
            return 0;
        
        if(!skip)
            return grid[i][j] == 1 ? 1 : 0;
        
        int count = 0;
        for (int k = 0; k < dx.length; count += countLiveNeighbors(grid, i + dx[k], j + dy[k++], false));
        
        return count;
    }

    private int countLiveNeighbors(int[][] grid, int i, int j) {
        int count = 0;

        for(int k = 0; k < dx.length; k++) {
            int r = i + dx[k];
            int c = j + dy[k];
            if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length)
                continue;
            
            count += grid[r][c];
        }

        return count;
    }
}
