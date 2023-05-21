class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null || s.length() != t.length())
            return false;
        
        int[] freq = new int[26];

        for(int i = 0; i < s.length(); i++) {
            freq[Character.toUpperCase(s.charAt(i)) - 'A']++;
            freq[Character.toUpperCase(t.charAt(i)) - 'A']--;
        }

        for(int i = 0; i < freq.length; i++)
            if(freq[i] != 0)
                return false;

        return true;
        
    }
}
