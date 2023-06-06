class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];

        return Math.min(solve(cost, 0, dp), solve(cost, 1, dp));
    }

    private int solve(int[] cost, int i, int[] dp) {
        if(i >= cost.length)
            return 0;
        
        if(dp[i] == 0)
            dp[i] = Math.min(
                        cost[i] + solve(cost, i + 1, dp), 
                        cost[i] + solve(cost, i + 2, dp)
                    );

        return dp[i];
    }
}
