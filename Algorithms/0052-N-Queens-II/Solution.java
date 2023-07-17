class Solution {
    private final int[] dx = {-1, -1, 1, 1};
    private final int[] dy = {-1, 1, -1, 1};

    public int totalNQueens(int n) {
        return DFS(new boolean[n][n], 0);
    }

    private int DFS(boolean[][] grid, int c) {
        if(c == grid.length)
            return 1;
        
        int k = 0;
        
        for(int r = 0; r < grid.length; r++) {
            if(isQueenSafe(grid, r, c)) {
                grid[r][c] = true;
                k += DFS(grid, c + 1);
                grid[r][c] = false;
            }
        }

        return k;
    }

    public boolean isQueenSafe(boolean[][] grid, int i, int j) {
        for(int k = 0; k < grid.length; k++) {
            if((grid[i][k] && k != j) || (grid[k][j] && k != i))
                return false;
        }

        for(int k = 0; k < dx.length; k++) {
            int r = i + dx[k], c = j + dy[k];
            while(!isOutOfRange(grid, r, c)) {
                if(grid[r][c])
                    return false;
                
                r += dx[k];
                c += dy[k];
            }
        }

        return true;
    }

    public boolean isOutOfRange(boolean[][] grid, int i, int j) {
        return i < 0 || i >= grid.length || j < 0 || j >= grid[0].length;
    }
}
