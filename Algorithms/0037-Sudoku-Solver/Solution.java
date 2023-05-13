class Solution {
    public void solveSudoku(char[][] board) {
        solveSudoku(board, 0, 0);
    }

    private boolean solveSudoku(char[][] board, int row, int col) {
        if(row == 9)
            return true;
        
        if(col == 9)
            return solveSudoku(board, row + 1, 0);
        
        if(board[row][col] != '.')
            return solveSudoku(board, row, col + 1);

        for(char c = '1'; c <= '9'; c++) {
            if(isValid(board, row, col, c)) {
                board[row][col] = c;
                if(solveSudoku(board, row, col + 1))
                    return true;
            }
            board[row][col] = '.';
        }
        return false;
    }

    private boolean isValid(char[][] board, int row, int col, int val) {
        for(int i = 0; i < 9; i++)
            if(board[i][col] == val || board[row][i] == val)
                return false;
        
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                if(board[row - row % 3 + i][col - col % 3 + j] == val)
                    return false;
        
        return true;
    }
}
