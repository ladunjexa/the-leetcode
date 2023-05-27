class Solution {
    public int maxOperations(int[] nums, int k) { 
        Arrays.sort(nums);

        int low = 0, high = nums.length - 1, op = 0;

        while(low < high) {
            int sum = nums[low] + nums[high];
            if(sum == k) {
                op++;
                low++;
                high--;
            } else if(sum < k)
                low++;
            else
                high--;
        }
        return op;
    }
}
