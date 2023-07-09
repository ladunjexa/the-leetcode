class Solution {
    public int lengthOfLIS(int[] nums) {
        int N = nums.length, maxLen = Integer.MIN_VALUE;
        int[] dp = new int[N];

        for(int i = 0; i < N; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++)
                if(nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            
            maxLen = Math.max(maxLen, dp[i]);
        }
        
        return maxLen;
    }
}
