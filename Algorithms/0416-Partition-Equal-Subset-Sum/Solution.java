class Solution {
    Boolean[][] memo;

    public boolean canPartition(int[] nums) {
        int N = nums.length, total = 0;

        for(int i = 0; i < N; i++)
            total += nums[i];

        if(total % 2 != 0)
            return false;

        memo = new Boolean[N][total / 2 + 1];

        return canPartition(nums, 0, total / 2);    
    }

    private boolean canPartition(int[] v, int i, int t) {
        if(t < 0 || i >= v.length)
            return false;
        
        if(t == 0)
            return true;
        
        if(memo[i][t] != null)
            return memo[i][t];
        
        return memo[i][t] = canPartition(v, i + 1, t - v[i]) || canPartition(v, i + 1, t);
    }
}
