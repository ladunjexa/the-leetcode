class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double max = Double.NEGATIVE_INFINITY;
        int N = nums.length, sum = 0;
        
        for(int i = 0; i < N; i++) {
            sum += nums[i]; // Add the current element to the sum
            if(i >= k - 1) { // Check if we have a subarray of size k
                max = Math.max(max, (double) sum / k); // Update max average if necessary
                sum -= nums[i - k + 1]; // Remove the leftmost element from the sum
            }
        }

        return max;
    }
}
