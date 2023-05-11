class Solution {
    public int diagonalSum(int[][] mat) {
        int N = mat.length, diagonalSum = 0;
        for(int i = 0; i < N; i++)
            diagonalSum += mat[i][i] + mat[i][N - 1 - i];
        
        return diagonalSum - ((N % 2 != 0) ? mat[N / 2][N / 2] : 0);
    }
}
