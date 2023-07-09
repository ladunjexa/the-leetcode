class Solution {
    public int jump(int[] nums) {
        int N = nums.length;

        int[] dp = new int[N];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for(int i = 1; i < N; i++)
            for(int j = 0; j < i; j++)
                if(j + nums[j] >= i)
                    dp[i] = Math.min(dp[i], dp[j] + 1);
        
        return dp[N - 1];
    }
}
