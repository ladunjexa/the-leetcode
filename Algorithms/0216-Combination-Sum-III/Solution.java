class Solution {
    List<List<Integer>> combinations = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        combinationSum3(k, n, 1, new ArrayList<Integer>());

        return combinations;    
    }

    private void combinationSum3(int k, int n, int i, List<Integer> el) {
        if(k == 0 && n == 0) {
            combinations.add(new ArrayList<>(el));
            return;
        }

        if(n < 0 || k == 0 || i > 9)
            return;
        
        el.add(i);
        combinationSum3(k - 1, n - i, i + 1, el);
        el.remove(el.size() - 1);
        combinationSum3(k, n, i + 1, el);
    }
}
