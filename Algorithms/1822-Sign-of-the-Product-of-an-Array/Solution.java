class Solution {
    public int arraySign(int[] nums) {
        int len = nums.length, neg = 0;
        for(int i = 0; i < (len / 2); i++) {
            if(nums[i] == 0 || nums[len - 1 - i] == 0)
                return 0;
            if(nums[i] < 0)
                neg++;
            if(nums[len - 1 - i] < 0)
                neg++;
        }
        if(len % 2 != 0) {
            int med =  nums[(len / 2)];
            if(med < 0) neg++;
            if(med == 0) return 0;
        }

        return (neg % 2 == 0) ? 1 : -1;
    }
}