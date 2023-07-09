class Solution {
    public void nextPermutation(int[] nums) {
        int N = nums.length, p = -1;

        for(int i = N - 2; i >= 0; i--)
            if(nums[i] < nums[i + 1]) {
                p = i;
                break;
            }
        
        if(p == -1) {
            int lo = 0, hi = N - 1;

            while(lo < hi) {
                swap(nums, lo, hi);
                lo++;
                hi--;
            }
        } else {
            for(int i = N - 1; i > p; i--)
                if(nums[i] > nums[p]) {
                    swap(nums, i, p);
                    break;
                }
            
            int lo = p + 1, hi = N - 1;
            while(lo < hi) {
                swap(nums, lo, hi);
                lo++;
                hi--;
            }
        }
    }

    private void swap(int[] v, int i, int j) {
        int t = v[i];
        v[i] = v[j];
        v[j] = t;
    }
}
