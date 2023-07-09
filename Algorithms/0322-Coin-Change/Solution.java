class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 0; i < coins.length; i++)
            for(int c = coins[i]; c <= amount; c++)
                if(dp[c - coins[i]] != Integer.MAX_VALUE)
                    dp[c] = Math.min(dp[c], dp[c - coins[i]] + 1);
        
        return (dp[amount] == Integer.MAX_VALUE) ? -1 : dp[amount];
    }
}
