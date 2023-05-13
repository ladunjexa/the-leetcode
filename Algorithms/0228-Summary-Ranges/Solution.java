class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> summary = new ArrayList<>();
        
        String current = null;

        for(int i = 0; i < nums.length; i++) {
            current = "" + nums[i];

            while(i < nums.length - 1 && nums[i] == nums[i + 1] - 1)
                i++;
            
            if(!current.equals("" + nums[i]))
                current += "->" + nums[i];

            summary.add(current);
            current = null;
        }

        return summary;
    }
}
