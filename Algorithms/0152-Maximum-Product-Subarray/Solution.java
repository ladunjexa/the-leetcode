class Solution {
    public int maxProduct(int[] nums) {
        int prefix = 1, suffix = 1, res = Integer.MIN_VALUE, N = nums.length;

        for(int i = 0; i < N; i++) {
            if(prefix == 0) prefix = 1;
            if(suffix == 0) suffix = 1;

            prefix = prefix * nums[i];
            suffix = suffix * nums[N - 1 - i];
            res = Math.max(res, Math.max(prefix, suffix));
        }

        return res;
    }
}
