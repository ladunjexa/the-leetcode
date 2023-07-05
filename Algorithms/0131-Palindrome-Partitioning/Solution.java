class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> out = new ArrayList<List<String>>();

        backtrack(out, new ArrayList<String>(), s, 0);

        return out;  
    }

    private void backtrack(List<List<String>> out, List<String> curr, String s, int lo) {
        if(lo == s.length()) {
            out.add(new ArrayList<>(curr));
            return;
        }

        for(int i = lo; i < s.length(); i++) {
            if(isPalindrome(s, lo, i)) {
                curr.add(s.substring(lo, i + 1));
                backtrack(out, curr, s, i + 1);
                curr.remove(curr.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int lo, int hi) {
        while(lo < hi)
            if(s.charAt(lo++) != s.charAt(hi--))
                return false;

        return true;
    }
}
