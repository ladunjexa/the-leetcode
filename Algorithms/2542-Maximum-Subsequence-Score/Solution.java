class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int N = nums1.length;

        int[][] nums = new int[N][2];

        for(int i = 0; i < N; i++)
            nums[i] = new int[] { nums1[i], nums2[i] };
        
        Arrays.sort(nums, (a, b) -> b[1] - a[1]);

        long out = 0, sum = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

        for(int i = 0; i< N; i++) {
            sum += nums[i][0];
            queue.offer(nums[i][0]);

            if(queue.size() == k) {
                out = Math.max(out, sum * nums[i][1]);
                sum -= queue.poll();
            }
        }

        return out;
    }
}
