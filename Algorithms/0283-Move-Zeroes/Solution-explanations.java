class Solution {
    public void moveZeroes(int[] nums) {
        // initialize variables for tracking destination index of the first available position to put a non-zero number, current index, and a placeholder value for swaping.
        int dest = 0, i = 0, swap = Integer.MIN_VALUE;

        // iterate through the array
        do {
            if(nums[i] == 0) continue; // if the current element is 0, skip to the next iteration

            // swap the current element with the element at the destination index
            swap = nums[dest];
            nums[dest++] = nums[i];
            nums[i] = swap;

        } while(++i < nums.length); // continue the loop while the current index is less than the length of the array
    }
}
