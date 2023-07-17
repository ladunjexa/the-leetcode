class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int[] max = {0, nums[0]}, min = {0, nums[0]};
        int total = 0;

        for(int i = 0; i < nums.length; i++) {
            int e = nums[i];

            max[0] = Math.max(max[0], 0) + e;
            max[1] = Math.max(max[1], max[0]);

            min[0] = Math.min(min[0], 0) + e;
            min[1] = Math.min(min[1], min[0]);

            total += e;
        }

        return (total == min[1]) ? max[1] : Math.max(max[1], total - min[1]);
    }
}
