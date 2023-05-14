class Solution {
    public int[][] transpose(int[][] matrix) {
        int N = matrix.length, M = matrix[0].length, r = 0, c = 0;

        int[][] transposed = new int[M][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                transposed[r][c] = matrix[i][j];
                r++;

                if(r % M == 0) {
                    r = 0;
                    c++;
                }
            }
        }

        return transposed;
    }
}
