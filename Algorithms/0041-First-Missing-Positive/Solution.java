class Solution {
    public int firstMissingPositive(int[] nums) {
        int N = nums.length, i = 0;

        while(i < N) {
            int el = nums[i];

            if(el >= 1 && el <= N) {
                if(nums[el - 1] != el) {
                    nums[i] = nums[el - 1];
                    nums[el - 1] = el;
                } else
                    i++;
            } else
                i++;
        }

        for(int j = 0; j < N; j++)
            if(nums[j] != j + 1)
                return j + 1;
        
        return N + 1;
    }
}
