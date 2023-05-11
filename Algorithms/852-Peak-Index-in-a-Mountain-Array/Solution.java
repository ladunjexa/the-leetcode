class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int N = arr.length - 1;

        if(arr[0] > arr[1])
            return 0;
        
        if(arr[N] > arr[N])
            return N;
        
        int low = 1, high = N;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
                return mid;
            else if(arr[mid] < arr[mid - 1])
                high = mid - 1;
            else
                low = mid + 1;
        }

        return -1;
    }
}
