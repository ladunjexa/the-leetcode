class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<List<Integer>>();

        combinationSum(candidates, target, 0, new ArrayList<Integer>(), combinations);   

        return combinations;
    }

    public void combinationSum(int[] c, int t, int i, List<Integer> current, List<List<Integer>> combinations) {
        if (t < 0 || i >= c.length)
            return;

        if (t == 0) {
            combinations.add(new ArrayList<>(current));
            return;
        }

        combinationSum(c, t, i + 1, current, combinations);

        List<Integer> with = new ArrayList<>(current);
        with.add(c[i]);

        combinationSum(c, t - c[i], i, with, combinations);
    }

}
