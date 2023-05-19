class Solution {
    public int specialArray(int[] nums) {
        int low = 0, high = nums.length;

        while(low <= high) {
            int mid = low + (high - low) / 2, 
                cgoe = countGreaterOrEqual(nums, mid);
                
            if(cgoe == mid)
                return mid;
            else if(cgoe > mid)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }

    private int countGreaterOrEqual(int[] m, int v) {
        int c = 0;

        for(int i = 0; i < m.length; i++)
            if(m[i] >= v)
                c++;
        
        return c;
    }
}
