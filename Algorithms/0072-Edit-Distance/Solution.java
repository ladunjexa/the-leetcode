class Solution {
    public int minDistance(String word1, String word2) {
        int N = word1.length(), M = word2.length();
        int[][] dp = new int[N + 1][M + 1];

        for(int i = 0; i <= N; i++)
            dp[i][0] = i;
        
        for(int j = 0; j <= M; j++)
            dp[0][j] = j;
        
        for(int i = 1; i <= N; i++)
            for(int j = 1; j <= M; j++)
                if(word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    int insert = dp[i][j - 1] + 1,
                        delete = dp[i - 1][j] + 1,
                        replace = dp[i - 1][j - 1] + 1;

                    dp[i][j] = Math.min(replace, Math.min(insert, delete));
                } else
                    dp[i][j] = dp[i - 1][j - 1];

        return dp[N][M];
    }
}
