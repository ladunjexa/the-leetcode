class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3)
            return 0;

        Arrays.sort(nums);

        int current = Integer.MAX_VALUE, closest = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length - 2; i++) {
            int low = i + 1, high = nums.length - 1;
            while(low < high) {
                int sum = (nums[i] + nums[low] + nums[high]);
                int diff = Math.abs(sum - target);

                if(diff < current) {
                    current = diff;
                    closest = sum;
                }

                if(sum < target)
                    low++;
                else if(sum > target)
                    high--;
                else
                    return sum;
            }
        }
        
        return closest;
    }
}