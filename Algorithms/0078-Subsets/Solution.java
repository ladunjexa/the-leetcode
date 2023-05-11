class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsequences = new ArrayList<>();
        subsets(nums, 0, new ArrayList<>(), subsequences);
        return subsequences;
    }

    private void subsets(int[] array, int pos, List<Integer> set, List<List<Integer>> complete) {
        if(pos == array.length) {
            complete.add(new ArrayList<>(set));
            return;
        }

        set.add(array[pos]);
        subsets(array, pos + 1, set, complete);
        set.remove(set.size() - 1);
        subsets(array, pos + 1, set, complete);
    }
}