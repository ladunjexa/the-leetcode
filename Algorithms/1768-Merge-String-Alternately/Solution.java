class Solution {
    public String mergeAlternately(String word1, String word2) {
        int N = word1.length(), K = word2.length(), j = 0, k = 0;
        String alt = "";
        
        for(int i = 0; i < N + K; i++) {
            if(j == N)
                return alt + word2.substring(k, K);
            else if(k == K)
                return alt + word1.substring(j, N);
            
            alt += (i % 2 == 0) ? word1.charAt(j++) : word2.charAt(k++);
        }

        return alt;
    }
}
