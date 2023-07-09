class Solution {
    public void setZeroes(int[][] matrix) {
        int M = matrix.length, N = matrix[0].length;

        boolean[] row = new boolean[M], col = new boolean[N];

        for(int i = 0; i < M; i++)
            for(int j = 0; j < N; j++)
                if(matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }

        for(int i = 0; i < M; i++)
            for(int j = 0; j < N; j++)
                if(matrix[i][j] != 0 && (row[i] || col[j]))
                    matrix[i][j] = 0;
    }
}
