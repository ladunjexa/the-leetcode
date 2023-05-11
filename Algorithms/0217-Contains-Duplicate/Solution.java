class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);

        int len = nums.length;

        for(int i = 0; i < len / 2; i++) 
            if(nums[i] == nums[i + 1] || nums[len - i - 1] == nums[len - i - 2])
                return true;

        return false;
    }
}