class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> out = new ArrayList<>();

        for(int i = 0; i < k; i++) {
            while(!dq.isEmpty() && nums[i] >= nums[dq.peekLast()])
                dq.pollLast();

            dq.offerLast(i);
        }

        out.add(nums[dq.peekFirst()]);

        for(int i = k; i < nums.length; i++) {
            if(dq.peekFirst() == i - k)
                dq.pollFirst();
            
            while(!dq.isEmpty() && nums[i] >= nums[dq.peekLast()])
                dq.pollLast();
            
            dq.offerLast(i);
            out.add(nums[dq.peekFirst()]);
        }

        return out.stream().mapToInt(i -> i).toArray();
    }
}
