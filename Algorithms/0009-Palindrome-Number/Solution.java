class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;

        String n = String.valueOf(x);

        for(int i = 0; i < n.length() / 2; i++)
            if(!(n.charAt(i) == n.charAt(n.length() -  1 - i)))
                return false;
                
        return true;
    }
}