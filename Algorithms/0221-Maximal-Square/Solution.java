class Solution {
    private int count = 0;
    private Integer[][] memo;

    public int maximalSquare(char[][] matrix) {
        memo = new Integer[matrix.length][matrix[0].length];
        maximalSquare(matrix, 0, 0);

        return (count * count);    
    }

    private int maximalSquare(char[][] matrix, int i, int j) {
        if(i >= matrix.length || j >= matrix[0].length)
            return 0;
        
        if(memo[i][j] != null)
            return memo[i][j];

        int r = maximalSquare(matrix, i, j + 1);
        int d = maximalSquare(matrix, i + 1, j);
        int diag = maximalSquare(matrix, i + 1, j + 1);

        int out = 0;

        if(matrix[i][j] == '1') {
            out = 1 + Math.min(r, Math.min(d, diag));
            count = Math.max(out, count);
        }

        return memo[i][j] = out;
    }
}
