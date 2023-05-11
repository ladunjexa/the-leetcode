class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        Set<List<Integer>> set = new HashSet<>();
        int len = nums.length;

        if(len < 3) return new ArrayList<>(set);

        for(int i = 0; i < (len - 2); i++) {
            int nd = i + 1;
            int th = len - 1;

            while(nd < th) {
                int sum = nums[i] + nums[nd] + nums[th];
                if(sum == 0) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[nd]);
                    triplet.add(nums[th]);

                    set.add(triplet);
                    nd++;
                } else if(sum < 0)
                    nd++;
                else
                    th--;
            }
            
        }

        return new ArrayList<>(set);
    }
}