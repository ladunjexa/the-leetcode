class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.isEmpty())
            return 0;

        return strStr(haystack, needle, 0);
    }
    
    private int strStr(String haystack, String needle, int startIndex) {
        if(haystack.startsWith(needle))
            return startIndex;
        
        if(haystack.length() != 1)
            return strStr(haystack.substring(1), needle, startIndex + 1);
            
        return -1;
    }
}