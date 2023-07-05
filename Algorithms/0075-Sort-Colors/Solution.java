class Solution {
    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] a, int lo, int hi) {
        if(lo < hi) {
            int pi = partition(a, lo, hi);
            quickSort(a, lo, pi - 1);
            quickSort(a, pi + 1, hi);
        }
    }

    private int partition(int[] a, int lo, int hi) {
        int start = lo, end = hi, pivot = a[lo];

        while(start < end) {
            while(start < end && a[start] <= pivot)
                start++;
            while(a[end] > pivot)
                end--;
            if(start < end)
                swap(a, start, end);
        }
        swap(a, lo, end);

        return end;
    }

    private void swap(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
}
