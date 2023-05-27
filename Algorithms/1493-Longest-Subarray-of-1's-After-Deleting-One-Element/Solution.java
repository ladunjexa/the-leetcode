class Solution {
    public int longestSubarray(int[] nums) {
        int start = 0, current = 0, max = 0;
        boolean deleted = false;
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1)
                current++;
            else if(nums[i] == 0 && !deleted) {
                current++;
                deleted = true;
            } else {
                max = Math.max(max, current);
                i = start++;
                current = 0;
                deleted = false;
            }
        }

        max = Math.max(max, current);

        return (max - 1);
    }
}
