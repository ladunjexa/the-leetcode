class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int N = nums1.length, M = nums2.length, maxDistance = 0;
        
        for(int i = 0; i < N; ++i) {
            int k = binarySearch(nums2, nums1[i]);
            if(k > i)
                maxDistance = Math.max(maxDistance, k - i);
        }
        
        return maxDistance;
    }
    
    private int binarySearch(int[] m, int n) {
        int low = 0, high = m.length - 1;
        
        while(low < high) {
            int mid = low + (high - low + 1) / 2;
            if(m[mid] < n)
                high = mid - 1;
            else
                low = mid;
        }
        
        return low;
    }
}
