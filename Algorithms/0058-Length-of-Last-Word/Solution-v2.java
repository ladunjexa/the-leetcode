class Solution {
    public int lengthOfLastWord(String s) {
        int n = 0, k = s.length() - 1;
        
        // Skip trailing spaces
        while (k >= 0 && s.charAt(k) == ' ') {
            k--;
        }
        
        // Count non-space characters from the end
        while (k >= 0 && s.charAt(k) != ' ') {
            n++;
            k--;
        }
        
        return n;
    }
}
