class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> seen = new HashSet<Integer>();
        HashSet<Integer> inter = new HashSet<Integer>();

        for(int i = 0; i < nums1.length; i++)
            if(!seen.contains(nums1[i]))
                seen.add(nums1[i]);
            
        for(int i = 0; i < nums2.length; i++)
            if(seen.contains(nums2[i]))
                inter.add(nums2[i]);
        
        int[] arr = new int[inter.size()];
        int e = 0;

        for(int i : inter)
            arr[e++] = i;

        return arr;
    }
}
