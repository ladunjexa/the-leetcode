class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        combine(1, n, k, new ArrayList<Integer>(), res);

        return res;
    }
    
    private static void combine(int start, int n, int k, List<Integer> set, List<List<Integer>> res) {
        if(set.size() == k) {
            res.add(new ArrayList<>(set));
            return;
        }

        for(int i = start; i <= n; i++) {
            set.add(i);
            combine(i + 1, n, k, set, res);
            set.remove(set.size() - 1);
        }
    }
}
