class Solution {
    public boolean exist(char[][] board, String word) {
        int index = 0, N = board.length, M = board[0].length;
        boolean output = false;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(board[i][j] == word.charAt(0)) {
                    boolean[][] v = new boolean[N][M];
                    output = output | backtrack(i, j, board, index, word, v);
                }
            }
        }

        return output;
    }

    private boolean backtrack(int i, int j, char[][] board, int index, String word, boolean[][] v) {
        if(index >= word.length())
            return true;
        
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index) || v[i][j])
            return false;
        
        v[i][j] = true;
        boolean u = backtrack(i - 1, j, board, index + 1, word, v),
                d = backtrack(i + 1, j, board, index + 1, word, v),
                l = backtrack(i, j - 1, board, index + 1, word, v),
                r = backtrack(i, j + 1, board, index + 1, word, v);
        v[i][j] = false;

        return u | d | l | r;
    }
}
