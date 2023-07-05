class Solution {
    public int findDuplicate(int[] nums) {
         int[] instances = new int[nums.length];

         for(int i = 0; i < nums.length; i++)
             if(++instances[nums[i]] > 1)
                return nums[i];

         return -1;
    }
}
