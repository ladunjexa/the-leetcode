class Solution {
    public int subarraySum(int[] nums, int k) {
        int N = nums.length;
        long sum = 0;
        long[] ov = new long[N];

        for(int i = 0; i < N; i++) {
            sum += nums[i];
            ov[i] = sum;
        }

        Map<Long, Integer> map = new HashMap<>();
        map.put((long)0, 1);

        int c = 0;

        for(int i = 0; i < ov.length; i++) {
            if(map.containsKey(ov[i] - k))
                c += map.get(ov[i] - k);
            
            map.put(ov[i], map.getOrDefault(ov[i], 0) + 1);
        }

        return c;
    }
}
