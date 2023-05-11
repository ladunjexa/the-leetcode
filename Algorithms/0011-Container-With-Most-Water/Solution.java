class Solution {
    public int maxArea(int[] height) {
        int len = height.length, area = 0, low = 0, high = (len - 1);

        while(low < high) {
            int curr = (height[low] < height[high]) ? height[low] : height[high];
            curr *= (high - low);
            
            if(curr > area)
                area = curr;
            
            if(height[low] < height[high])
                low++;
            else
                high--;
        }

        return area;
    }
}