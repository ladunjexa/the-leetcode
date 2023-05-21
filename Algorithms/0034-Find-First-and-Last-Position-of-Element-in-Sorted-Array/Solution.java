class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[] {
            binarySearch(nums, target, true),
            binarySearch(nums, target, false)
        };
    }

    private int binarySearch(int[] nums, int target, boolean end) {
        int low = 0, high = nums.length - 1, result = -1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) {
                result = mid;
                if(!end)
                    low = mid + 1;
                else
                    high = mid - 1;
            } else if(nums[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return result;
    }
}
