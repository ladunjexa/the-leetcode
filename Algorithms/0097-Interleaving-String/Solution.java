class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int M = s1.length(), N = s2.length();

        if(N + M != s3.length())
            return false;
        
        return isInterleave(s1, s2, s3, 0, 0, new Boolean[M + 1][N + 1]);
    }

    private boolean isInterleave(String s1, String s2, String s3, int i, int j, Boolean[][] memo) {
        if(i + j == s3.length())
            return true;
        
        if(memo[i][j] != null)
            return memo[i][j];

        char ch = s3.charAt(i + j);
        
        boolean[] flags = {
            i < s1.length() && s1.charAt(i) == ch && isInterleave(s1, s2, s3, i + 1, j, memo), 
            j < s2.length() && s2.charAt(j) == ch && isInterleave(s1, s2, s3, i, j + 1, memo)
        };
        
        return memo[i][j] = (flags[0] || flags[1]);
    }
}
