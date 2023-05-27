class Solution {
   public boolean isSubsequence(String s, String t) {
        return isSubsequence(s, t, 0, 0);
    }

    private boolean isSubsequence(String s, String t, int i, int j) {
        if(i == s.length())
            return true;
        
        if(j == t.length())
            return false;

        return (s.charAt(i) == t.charAt(j) ? isSubsequence(s, t, i + 1, j + 1) : isSubsequence(s, t, i, j + 1));
    }
}
