class Solution {
    public int pivotIndex(int[] nums) {
        int total = 0, left = 0;
        
        for(int element : nums)
            total += element;
        
        for(int i = 0; i < nums.length; left += nums[i++])
            if(left * 2 == total - nums[i])
                return i;
        
        return -1;
    }
}
