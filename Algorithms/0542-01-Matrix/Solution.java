class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int N = mat.length, M = mat[0].length;
        
        if(mat == null || mat.length == 0 || mat[0].length == 0 || (N == 1 && M == 1))
            return mat;

        int[][] T = new int[N][M];

        for(int i = 0; i < N * M; i++) {
            int r = i / M, c = i % M;
            if(mat[r][c] == 0)
                continue;

            T[r][c] = (N + M);
            if(r > 0)
                T[r][c] = Math.min(T[r][c], T[r - 1][c] + 1);
            if(c > 0)
                T[r][c] = Math.min(T[r][c], T[r][c - 1] + 1);
        }

        for(int i = N * M - 1; i >= 0; i--) {
            int r = i / M, c = i % M;
            if(mat[r][c] == 0)
                continue;
            
            if(r < N - 1)
                T[r][c] = Math.min(T[r][c], T[r + 1][c] + 1);
            if(c < M - 1)
                T[r][c] = Math.min(T[r][c], T[r][c + 1] + 1);
        }

        return T;
    }
}
