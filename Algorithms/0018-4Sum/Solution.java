class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> sets = new HashSet<>();
        int len = nums.length;

        if(len < 4 || nums == null)
            return new ArrayList<>(sets);

        Arrays.sort(nums);
        long[] arr = Arrays.stream(nums).mapToLong((i) -> (long) i).toArray();

        for(int i = 0; i < (len - 3); i++) {
            for(int j = (i + 1); j < (len - 2); j++) {
                int low = j + 1, high = len - 1;
                while(low < high) {
                    long sum = (arr[i] + arr[j] + arr[low] + arr[high]);
                    if(sum == target) {
                        sets.add(List.of(nums[i], nums[j], nums[low], nums[high]));
                        low++;
                        high--;
                    }
                    else if(sum < target)
                        low++;
                    else
                        high--;
                }
            }
        }

        return new ArrayList<>(sets);   
    }
}