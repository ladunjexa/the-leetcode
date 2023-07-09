class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> indices = new ArrayList<Integer>();
        
        for(int i = 0; i <= s.length() - p.length(); i++)
            if(isAnagram(s.substring(i, i + p.length()), p))
                indices.add(i);

        return indices;
    }

    private boolean isAnagram(String s, String p) {
        int[] dp = new int[26];

        for(int i = 0; i < s.length(); i++) {
            dp[s.charAt(i) - 'a']++;
            dp[p.charAt(i) - 'a']--;
        }

        for(int i = 0; i < dp.length; i++)
            if(dp[i] != 0)
                return false;
        
        return true;
    }
}
