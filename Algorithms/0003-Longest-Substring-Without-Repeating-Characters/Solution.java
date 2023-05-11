class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> hash = new HashSet();
        int max = 0, n = s.length(), l = 0;

        for(int r = 0; r < n; r++) {
            while(!hash.add(s.charAt(r)))
                hash.remove(s.charAt(l++));
            
            max = Math.max(max, (r - l + 1));
        }

        return max;
    }
}