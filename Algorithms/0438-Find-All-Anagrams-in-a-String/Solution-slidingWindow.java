class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> indices = new ArrayList<Integer>();

        int[] targetCount = new int[26], windowCount = new int[26];

        for(char c : p.toCharArray())
            targetCount[c - 'a']++;

        for(int right = 0, left = 0; right < s.length(); right++) {
            windowCount[s.charAt(right) - 'a']++;

            if(right - left + 1 == p.length()) {
                if(isAnagram(windowCount, targetCount))
                    indices.add(left);
                
                windowCount[s.charAt(left) - 'a']--;
                left++;
            }
        }

        return indices;
    }

    private boolean isAnagram(int[] windowCount, int[] targetCount) {
        for (int i = 0; i < 26; i++)
            if (windowCount[i] != targetCount[i])
                return false;
        
        return true;
    }

}
