class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();

        for(int i = 0, N = nums.length; i < N; i++) {
            heap.add(nums[i]);
            if(heap.size() > k)
                heap.poll();
        }

        return heap.peek();
    }
}
