class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> res = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(res.containsKey(complement))
                return new int[] { res.get(complement), i };
            res.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }
}