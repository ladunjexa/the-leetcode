class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        if(nums.length == 0 || target == 0)
            return 0;

        int currSum = 0, count = 0, minCount = Integer.MAX_VALUE;
        for(int hi = 0, lo = 0; hi < nums.length; hi++) {
            currSum += nums[hi];

            while(currSum >= target) {
                minCount = Math.min(minCount, hi - lo + 1);
                currSum -= nums[lo];
                lo++;
            }
        }  

        return minCount == Integer.MAX_VALUE ? 0 : minCount;
    }
}
