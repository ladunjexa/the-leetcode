class Solution {
    public int subsetXORSum(int[] nums) {
        return subsetXORSum(nums, 0, 0);
    }

    private int subsetXORSum(int[] nums, int index, int xor) {
        if(index == nums.length) 
            return xor;
            
        return subsetXORSum(nums, index + 1, xor ^ nums[index]) + subsetXORSum(nums, index + 1, xor);
    }
}