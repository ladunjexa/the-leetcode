class Solution {
    public int longestOnes(int[] nums, int k) {
        int start = 0, current = 0, max = 0, flipped = k;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1)
                current++;
            else if(nums[i] == 0 && flipped > 0) {
                current++;
                flipped--;
            } else {
                max = Math.max(max, current);
                i = start++;
                current = 0;
                flipped = k;
            }
        }

        max = Math.max(max, current);

        return max;
    }
}
