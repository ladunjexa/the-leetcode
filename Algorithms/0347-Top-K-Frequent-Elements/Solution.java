class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(k == nums.length)
            return nums;
        
        Map<Integer, Integer> hashMap = new HashMap<>();

        for(int n : nums)
            hashMap.put(n, hashMap.getOrDefault(n, 0) + 1);
        
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> hashMap.get(a) - hashMap.get(b));

        for(int n : hashMap.keySet()) {
            pq.add(n);
            if(pq.size() > k)
                pq.poll();
        }

        int[] top = new int[k];

        for(int i = k - 1; i >= 0; i--)
            top[i] = pq.poll();
        
        return top;
    }
}
