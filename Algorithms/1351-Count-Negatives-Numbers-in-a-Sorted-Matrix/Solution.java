class Solution {
    public int countNegatives(int[][] grid) {
        int negatives = 0;

        for(int i = 0; i < grid.length; i++)
            negatives += binarySearch(grid[i]);

        return negatives;
    }

    private int binarySearch(int[] arr) {
        int negatives = 0, low = 0, high = arr.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] < 0) {
                negatives += high - mid + 1;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        
        return negatives;
    }
}
