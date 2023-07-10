class Solution {
    public String minWindow(String s, String t) {
        int[] sChars = new int[58], tChars = new int[58];

        for(int i = 0; i < t.length(); i++)
            tChars[t.charAt(i) - 'A']++;

        int c = 0, lo = 0, index = -1, result = Integer.MAX_VALUE;

        for(int hi = 0; hi < s.length(); hi++) {
            int ch = s.charAt(hi) - 'A';
            sChars[ch]++;

            if(sChars[ch] <= tChars[ch])
                c++;
            
            if(c != t.length())
                continue;
            
            while(sChars[s.charAt(lo) - 'A'] > tChars[s.charAt(lo) - 'A'])
                sChars[s.charAt(lo++) - 'A']--;
            
            if((hi - lo + 1) < result) {
                result = (hi - lo + 1);
                index = lo;
            }
        }
        
        return (index == -1) ? "" : s.substring(index, index + result);
    }

}
