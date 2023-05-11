class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet relcomplement_1 = new HashSet<Integer>(), 
                relcomplement_2 = new HashSet<Integer>(),
                intersection = new HashSet<Integer>();
        
        for(int i = 0; i < nums1.length; i++)
            relcomplement_1.add(nums1[i]);
        
        for(int i = 0; i < nums2.length; i++)
            if(relcomplement_1.contains(nums2[i])) {
                relcomplement_1.remove(nums2[i]);
                intersection.add(nums2[i]);
            } else if(!intersection.contains(nums2[i]))
                relcomplement_2.add(nums2[i]);
        
        return new ArrayList<>() {{ 
            add(new ArrayList<>(relcomplement_1)); 
            add(new ArrayList<>(relcomplement_2)); 
        }};
    }
}