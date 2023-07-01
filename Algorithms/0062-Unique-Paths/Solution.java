class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        for(int i = 0; i < m; i++)
            Arrays.fill(dp[i], Integer.MIN_VALUE);

        return uniquePaths(m, n, 0, 0, dp);
    }

    private int uniquePaths(int M, int N, int i, int j, int[][] dp) {
        if(i == M - 1 && j == N - 1)
            return 1;
        
        if(i >= M || j >= N)
            return 0;
        
        if(dp[i][j] != Integer.MIN_VALUE)
            return dp[i][j];
        
        int down = uniquePaths(M, N, i + 1, j, dp);
        int right = uniquePaths(M, N, i, j + 1, dp);
        
        return dp[i][j] = (down + right);
    }
}
