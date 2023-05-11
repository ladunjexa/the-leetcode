class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length, startIndex = 0, endIndex = (len - 1);
        k %= len;

        reverse(nums, startIndex, endIndex - k);
        reverse(nums, len - k, endIndex);
        reverse(nums, startIndex, endIndex);
    }

    private void reverse(int[] nums, int i, int j) {
        while(i < j) {
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i++] ^= nums[j--];
        }
    }
}