class Solution {
    public void moveZeroes(int[] nums) {
        int dest = 0, i = 0, swap = Integer.MIN_VALUE;

        do {
            if(nums[i] == 0) continue;
            swap = nums[dest];
            nums[dest++] = nums[i];
            nums[i] = swap;
        } while(++i < nums.length);

    }
}
