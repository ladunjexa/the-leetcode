class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int N = nums.length;

        if(nums[N - 1] != N)
            return N;
        
        for(int i = 0; i < N; i++)
            if(i != nums[i])
                return i;
        
        return -1;
    }
}
