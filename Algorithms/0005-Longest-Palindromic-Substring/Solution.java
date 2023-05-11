class Solution {
    public String longestPalindrome(String s) {
        int len = s.length(), max = 0;
        String palindrome = s.substring(0, 1);

        if(len == 0 || len == 1)
            return palindrome;
        
        if(isPalindrome(s)) 
            return s;

        for(int i = 0; i < len; i++) {
            for(int j = len; j > 0 && (j >= i); j--) {
                String sub = s.substring(i, j);
                if(isPalindrome(sub) && sub.length() > max) {
                    max = sub.length();
                    palindrome = sub;
                }
            }
        }

        return palindrome;
    }

    private boolean isPalindrome(String s) {
        int len = s.length();
        if(len == 1) return true;
        
        for(int i = 0; i < (len / 2); i++)
            if(s.charAt(i) != s.charAt(len - 1 - i))
                return false;
        
        return true;
    }
}