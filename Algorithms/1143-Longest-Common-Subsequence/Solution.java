class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.equals(text2))
            return text1.length();
        
        int N = text1.length(), M = text2.length();
        int[][] memo = new int[N + 1][M + 1];

        for(int i = 0; i <= N; i++)
            Arrays.fill(memo[i], - 1);

        return longestCommonSubsequence(text1, text2, N, M, memo);
    }

    private int longestCommonSubsequence(String w1, String w2, int N, int M, int[][] memo) {
        if(N == 0 || M == 0)
            memo[N][M] = 0;
        
        if(memo[N][M] != -1)
            return memo[N][M];

        if(w1.charAt(N - 1) == w2.charAt(M - 1))
            memo[N][M] = 1 + longestCommonSubsequence(w1, w2, N - 1, M - 1, memo);
        else
            memo[N][M] = Math.max(longestCommonSubsequence(w1, w2, N - 1, M, memo), longestCommonSubsequence(w1, w2, N, M - 1, memo));

        return memo[N][M];
    }
}
