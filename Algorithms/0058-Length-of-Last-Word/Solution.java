class Solution {
    public int lengthOfLastWord(String s) {
        int n = 0, k = s.length() - 1;

        while(s.charAt(k) == ' ')
            k--;
            
        while(k > n && s.charAt(k - n) != ' ')
            n++;

        return s.charAt(k - n) != ' ' && (n == 0 || n == k) ? k + 1 : n;
    }
}
