class Solution {
    public boolean isPalindrome(String s) {
        if(s.isEmpty() || s.length() == 1)
            return true;

        int low = 0, high = s.length() - 1;

        while(low <= high) {
            char l = s.charAt(low), r = s.charAt(high);
            if(!isValid(l))
                low++;
            else if(!isValid(r))
                high--;
            else {
                if(!isEqual(l, r))
                    return false;
                low++;
                high--;
            }
        }
        
        return true;
    }

    private static boolean isEqual(char n, char k) {
        return (Character.toLowerCase(n) == Character.toLowerCase(k));
    }

    private static boolean isValid(char c) {
        return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z') || ('0' <= c && c <= '9');
    }
}