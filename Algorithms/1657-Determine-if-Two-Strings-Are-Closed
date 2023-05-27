class Solution {
    public boolean closeStrings(String word1, String word2) {
        int[] w = new int[26], u = new int[26];
        int N = word1.length(), K = word2.length();
        
        if(N != K)
            return false;
        
        for(int i = 0; i < N; i++) {
            w[word1.charAt(i) - 'a']++;
            u[word2.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < 26; i++)
            if((w[i] != 0 && u[i] == 0) || (w[i] == 0 && u[i] != 0))
                return false;
        
        Arrays.sort(w);
        Arrays.sort(u);

        for(int i = 0; i < 26; i++)
            if(w[i] != u[i])
                return false;
        
        return true;
    }
}
