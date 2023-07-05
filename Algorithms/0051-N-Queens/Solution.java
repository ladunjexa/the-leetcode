class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];

        List<List<String>> puzzle = new ArrayList<>();

        return solveNQueens(board, 0, puzzle);
    }

    private List<List<String>> solveNQueens(boolean[][] b, int r, List<List<String>> p) {
        if(r == b.length)
            p.add(toList(b));

        for(int c = 0; c < b.length; c++) {
            if(isQueenSafe(b, r, c)) {
                b[r][c] = true;
                solveNQueens(b, r + 1, p);
                b[r][c] = false;
            }
        }

        return p;
    }

    private boolean isQueenSafe(boolean[][] b, int r, int c) {
        for(int i = 0; i < r; i++)
            if(b[i][c]) return false;

        int leftDiagonal = Math.min(r, c);
        for(int i = 1; i <= leftDiagonal; i++)
            if(b[r - i][c - i]) return false;
        
        int rightDiagonal = Math.min(r, b.length - c - 1);
        for(int i = 1; i <= rightDiagonal; i++)
            if(b[r - i][c + i]) return false;
        
        return true;
    }

    private List<String> toList(boolean[][] b) {
        List<String> out = new ArrayList<>();

        for(boolean[] r : b) {
            StringBuilder sb = new StringBuilder();
            for(boolean i : r) 
                sb.append(!i ? "." : "Q");
            
            out.add(sb.toString());
        }

        return out;
    }
}
