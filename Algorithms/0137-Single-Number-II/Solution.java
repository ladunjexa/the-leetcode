class Solution {
    public int singleNumber(int[] nums) {
        int N = nums.length - 1;

        if(N == 0)
            return nums[0];
        
        Arrays.sort(nums);

        for(int i = 1; i < N; i++)
            if(nums[i] != nums[i - 1] && nums[i] != nums[i + 1])
                return nums[i];
        
        return nums[N] == nums[N - 1] ? nums[0] : nums[N];
    }
}
