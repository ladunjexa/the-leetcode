class Solution {
    public int numTilings(int n) {
        long[] dp = new long[Math.max(4, n + 1)];
        long mod = (long) (Math.pow(10, 9) + 7);

        dp[0] = 0 % mod;
        dp[1] = 1 % mod;
        dp[2] = 2 % mod;
        dp[3] = 5 % mod;
        
        for(int i = 4; i <= n; i++)
            dp[i] = (2 * dp[i - 1] + dp[i - 3]) % mod;

        return (int) dp[n];
    }
}
