class Solution {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int dist = 0;
        
        for(int i = 0; i < arr1.length; i++)
            if(hasElementsInRange(arr2, arr1[i] - d, arr1[i] + d))
                dist++;
        
        return dist;
    }

    private static boolean hasElementsInRange(int[] arr, int n, int k) {
        int low = 0, high = arr.length - 1;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] >= n && arr[mid] <= k)
                return false;
            else if(arr[mid] < n)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return true;
    }
}
