class Solution {
    private final int[] dx = {-1, 1, 0, 0};
    private final int[] dy = {0, 0, -1, 1};

    public void solve(char[][] board) {
        int M = board.length, N = board[0].length;

        for(int i = 0; i < M * N; i++) {
            int r = (i / N), c = (i % N);
            if((r == 0 || r == M - 1 || c == 0 || c == N - 1) && board[r][c] == 'O')
                markConnected(board, r, c);
        }

        for(int i = 0; i < M * N; i++) {
            int r = (i / N), c = (i % N);
            if(board[r][c] == 'X')
                continue;
            
            board[r][c] = (board[r][c] == 'O') ? 'X' : 'O';
        }
    }

    private void markConnected(char[][] grid, int i, int j) {
        int M = grid.length, N = grid[0].length;

        if(i < 0 || i >= M || j < 0 || j >= N || grid[i][j] != 'O')
            return;
        
        grid[i][j] = 'V';

        for(int k = 0; k < dx.length; markConnected(grid, i + dx[k], j + dy[k++]));

    }
}
