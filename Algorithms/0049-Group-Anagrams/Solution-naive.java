class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagrams = new ArrayList<List<String>>();
        boolean[] related = new boolean[strs.length];

        for(int i = 0; i < strs.length; i++) {
            if(related[i] == true)
                continue;

            List<String> set = new ArrayList<String>();

            set.add(strs[i]);
            related[i] = true;

            for(int j = 0; j < strs.length; j++)
                if(i != j && !related[j] && strs[i].length() == strs[j].length() && isAnagram(strs[i], strs[j])) {
                    set.add(strs[j]);
                    related[j] = true;
                }

            anagrams.add(set);
        }

        return anagrams;
    }

    public boolean isAnagram(String s, String t) {
        int[] dp = new int[26];

        for(int i = 0; i < s.length(); i++) {
            dp[s.charAt(i) - 'a']++;
            dp[t.charAt(i) - 'a']--;
        }

        for(int i = 0; i < dp.length; i++)
            if(dp[i] != 0)
                return false;

        return true;
    }
}
