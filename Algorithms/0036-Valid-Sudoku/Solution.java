class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length != 9 || board[0].length != 9)
            return false;

        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (board[i][j] != '.' && !isValidSudoku(board, i, j))
                    return false;

        return true;
    }
    
    private boolean isValidSudoku(char[][] board, int i, int j) {
        // row & column
        for(int k = 0; k < 9; k++)
            if((k != j && board[i][k] == board[i][j]) || (k != i && board[k][j] == board[i][j]))
                return false;

        // 3x3 square
        int row = (i / 3) * 3;
        int col = (j / 3) * 3;
        for(int k = row; k < row + 3; k++)
            for(int n = col; n < col + 3; n++)
                if(i != k && n != j && board[i][j] == board[k][n])
                    return false;

        return true;
    }
}