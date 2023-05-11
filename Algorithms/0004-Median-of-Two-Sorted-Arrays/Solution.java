class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length, len = len1 + len2, i = 0, j = 0, k = 0;
        int[] newSortedArray = new int[len];

        while(i <= len1 && j <= len2) {
            if(i == len1) {
                while(j < len2) newSortedArray[k++] = nums2[j++];
                break;
            } else if(j == len2) {
                while(i < len1) newSortedArray[k++] = nums1[i++];
                break;
            }
            
            newSortedArray[k++] = (nums1[i] < nums2[j]) ? nums1[i++] : nums2[j++];
        }
        return (len % 2 == 1) ? 
            newSortedArray[(int)len / 2] : ((double)(newSortedArray[(len / 2) - 1] + newSortedArray[(len / 2)]) / 2);
    }
}