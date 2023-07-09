class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
    
        Arrays.sort(nums);

        int maxStart = 0, maxEnd = 0, currStart = 0, currEnd = 0;
        
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i + 1])
                continue;
            
            if(nums[i] + 1 == nums[i + 1])
                currEnd++;
            else {
                currStart = i + 1;
                currEnd = i + 1;
            }

            if((maxEnd - maxStart) < (currEnd - currStart)) {
                maxStart = currStart;
                maxEnd = currEnd;
            }
        }

        return (maxEnd - maxStart) + 1;
    }
}
