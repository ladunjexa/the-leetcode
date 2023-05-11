class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int N1 = s1.length(), N2 = s2.length();
        if(N1 > N2) return false;

        int[] data = new int[26];
        int[] test = new int[26];
        
        for(char c : s1.toCharArray())
            data[c - 'a']++;
        
        for(int i = 0; i < s1.length(); i++)
            test[s2.charAt(i) - 'a']++;
        
        for(int i = 0; i < s2.length() - N1; i++) {
            if(equalsString(test, data))
                return true;
            test[s2.charAt(i + N1) - 'a']++;
            test[s2.charAt(i) - 'a']--;
        }

        return equalsString(test, data);
    }
    
    private boolean equalsString(int[] s1, int[] s2) {
        for(int i = 0; i < 26; i++)
            if(s1[i] != s2[i]) return false;

        return true;
    }

}
