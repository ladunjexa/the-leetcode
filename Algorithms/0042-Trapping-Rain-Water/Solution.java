class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1, maxLeft = 0, maxRight = 0, out = 0;

        while(left < right) {
            maxLeft = Math.max(maxLeft, height[left]);
            maxRight = Math.max(maxRight, height[right]);

            out += (maxLeft < maxRight) ? maxLeft - height[left++] : maxRight - height[right--];
        }

        return out;
    }
}
